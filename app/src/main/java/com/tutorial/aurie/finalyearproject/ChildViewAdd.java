package com.tutorial.aurie.finalyearproject;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.tutorial.aurie.finalyearproject.Objects.Child;

import java.util.Calendar;

/**
 * Created by aurie on 24/04/2017.
 */

public class ChildViewAdd extends AppCompatActivity {
    private boolean Notification = true;
    private DatabaseReference databaseReference;
    private ProgressDialog progressDialog;
    private EditText editTextChildName;
    private EditText editTextChildAge;
    private EditText editTextChildDOB;
    private EditText editTextGender;
    private EditText editTextParentNumber;
    private EditText editTextParentEmail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chld_view);

        //CircularImageView profileImageChild=(CircularImageView) findViewById(R.id.profileImageChild);
        CheckBox checkboxNotification=(CheckBox) findViewById(R.id.checkboxNotification);
        checkboxNotification.setEnabled(true);
        checkboxNotification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Notification = isChecked;
            }
        });
        findViewById(R.id.buttonSaveChild).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextChildName=(EditText) findViewById(R.id.editTextChildName);
                editTextChildAge=(EditText) findViewById(R.id.editTextChildAge);
                editTextChildDOB=(EditText) findViewById(R.id.editTextChildDOB);
                editTextGender=(EditText) findViewById(R.id.editTextGender);
                editTextParentNumber=(EditText) findViewById(R.id.editTextParentNumber);
                editTextParentEmail=(EditText) findViewById(R.id.editTextParentEmail);

                progressDialog = new ProgressDialog(ChildViewAdd.this);

                final String ChildName =editTextChildName.getText().toString();
                final String ChildAge = editTextChildAge.getText().toString();
                final String ChildDOB = editTextChildDOB.getText().toString();
                final String Gender = editTextGender.getText().toString();
                final String ParentNumber = editTextParentNumber.getText().toString();
                final String ParentEmail = editTextParentEmail.getText().toString();


                Log.e("Print", "Something here");


                databaseReference = FirebaseDatabase.getInstance().getReference().child("ChildList");
//                if (ChildName.isEmpty()) {
//                    Toast.makeText(ChildViewAdd.this, "Please type your full name", Toast.LENGTH_LONG).show();
//                    return;
//                } else if (ChildAge.isEmpty()) {
//                    Toast.makeText(ChildViewAdd.this, "Please enter child age", Toast.LENGTH_LONG).show();
//                    return;
//                } else if (Gender.isEmpty()) {
//                        Toast.makeText(ChildViewAdd.this, "Please enter child gender", Toast.LENGTH_LONG).show();
//                        return;
//                } else if (ChildDOB.isEmpty()) {
//                    Toast.makeText(ChildViewAdd.this, "Please enter your child's date of birth", Toast.LENGTH_LONG).show();
//                    return;
//                } else if (ParentNumber.isEmpty()) {
//                    Toast.makeText(ChildViewAdd.this, "Please type your phone number", Toast.LENGTH_LONG).show();
//                    return;
//                } else if (ParentEmail.isEmpty()) {
//                    Toast.makeText(ChildViewAdd.this, "Please type your email", Toast.LENGTH_LONG).show();
//                    return;
//                }
                progressDialog.setMessage("Processing...");
                progressDialog.show();
                String id = String.valueOf(Calendar.getInstance().getTimeInMillis());
                Child child = new Child(id,"ImageUrl",ChildName,ChildAge,Gender,ParentEmail,ParentNumber,Notification);
                databaseReference.child(id).setValue(child, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        progressDialog.hide();

                        if(databaseError == null){
                            Log.e("Great", "onComplete: Good news " );
                        }
                        else{
                            Log.e("Print", "Child not added",databaseError.toException());
                        }
                    }
                });
            }
        });
    }
}
