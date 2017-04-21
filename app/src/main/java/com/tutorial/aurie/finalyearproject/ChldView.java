package com.tutorial.aurie.finalyearproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.tutorial.aurie.finalyearproject.API.InformationDataProvider;
import com.tutorial.aurie.finalyearproject.Interfaces.InformationInterface;
import com.tutorial.aurie.finalyearproject.Objects.ChildMessage;
import com.tutorial.aurie.finalyearproject.Objects.NewsObject;

import java.util.Calendar;
import java.util.List;

public class ChldView extends AppCompatActivity {
    private ImageView imageView;
    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextDOB;
    private EditText editTextParentNumber;
    private EditText editTextParentEmail,phone,parentName;
    private EditText editTextGender;
    private CheckBox checkBoxNotification;
    private Button buttonSaveChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chld_view);
        Log.e("Hello","URl");
        InformationDataProvider informationDataProvider = new  InformationDataProvider(ChldView.this);
        informationDataProvider.getInformation(new InformationInterface() {
            @Override
            public void getInformations(List<NewsObject> newsObjects) {


            }
        });

         imageView = (ImageView) findViewById(R.id.profileImageChild);
         editTextName = (EditText) findViewById(R.id.editTextChildName);
         editTextAge = (EditText) findViewById(R.id.editTextChildAge);
         editTextDOB = (EditText) findViewById(R.id.editTextChildDOB);
         editTextParentNumber = (EditText) findViewById(R.id.editTextParentNumber);
         editTextParentEmail = (EditText) findViewById(R.id.editTextParentEmail);
         editTextParentEmail = (EditText) findViewById(R.id.editTextParentEmail);
        editTextGender= (EditText) findViewById(R.id.editTextGender);
        phone = (EditText) findViewById(R.id.editTextParentNumber);


         checkBoxNotification = (CheckBox) findViewById(R.id.checkboxNotification);
         buttonSaveChild = (Button) findViewById(R.id.buttonSaveChild);

        buttonSaveChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String age = editTextAge.getText().toString();
                String dob = editTextDOB.getText().toString();
                String number = editTextParentNumber.getText().toString();
                String email = editTextParentEmail.getText().toString();
                String gender = String.valueOf(editTextGender.getText());
                boolean notfication = checkBoxNotification.isEnabled();

                Log.e("Hello","URl");

                checkBoxNotification.getText().toString();
                String imageurl ="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTCQ1cCz5YKnxSITEUjqtBqaST_m141GadQcL_clqTsM6axS1Fh";
                ChildMessage childMessage = new ChildMessage(String.valueOf(Calendar.getInstance().getTimeInMillis()),imageurl,name,age,gender,"",email,phone.getText().toString(),notfication);
                childMessage.Save(childMessage);
                Log.e("CHildNew", "onClick: " + String.valueOf(childMessage.retrieveAll().size()));
            }
        });



    }
}
