package com.tutorial.aurie.finalyearproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import io.realm.Realm;


public class Signup extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        final EditText editTextFullname = (EditText) findViewById(R.id.editTextFullname);
        final EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        final EditText editTextPhoneNumber = (EditText) findViewById(R.id.editTextPhoneNumber);
        TextView textViewShortcutToLogin = (TextView) findViewById(R.id.textViewShortcutToLogIn);
        final Button buttonSignUp = (Button) findViewById(R.id.buttonSignUp);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

         final Realm realm = Realm.getDefaultInstance();


        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullName = editTextFullname.getText().toString();
                String phoneNumber = editTextPhoneNumber.getText().toString();
                String passWord = editTextPassword.getText().toString();
                final String id = String.valueOf(Calendar.getInstance().getTimeInMillis());

                Log.e("Print", "Something here");
                if (fullName.isEmpty()) {
                    Toast.makeText(Signup.this, "Please type your full name", Toast.LENGTH_LONG).show();
                    return;
                } else if (fullName.length() < 4) {
                    Toast.makeText(Signup.this, "Please enter a valid username", Toast.LENGTH_LONG).show();
                    return;
                } else if (phoneNumber.length() < 10) {
                    Toast.makeText(Signup.this, "Please enter a complete phone number", Toast.LENGTH_LONG).show();
                    return;
                } else if (phoneNumber.isEmpty()) {
                    Toast.makeText(Signup.this, "Please type your phone number", Toast.LENGTH_LONG).show();
                    return;
                } else if (passWord.isEmpty()) {
                    Toast.makeText(Signup.this, "Please type your full name", Toast.LENGTH_LONG).show();
                    return;
                } else if (passWord.length() < 6) {
                    Toast.makeText(Signup.this, "Password not strong enough", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    final User user = new User(fullName, phoneNumber, passWord);

                    Log.e("Print", "running");

                    progressBar.setVisibility(View.VISIBLE);
                    buttonSignUp.setEnabled(false);
                    Log.e("Print", "checking");

                    String email = phoneNumber + "@immune.com";

                    Log.e("Print", "runningagain");

                    mAuth.createUserWithEmailAndPassword(email, passWord)
                            .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    // to enable the button again --true
                                    buttonSignUp.setEnabled(true);

                                    Log.e("Print", "how about here");

                                    if (task.isSuccessful()) {
                                        UserInfo userInfo = task.getResult().getUser();

                                        DatabaseReference currentUser = mDatabase.child(id);
                                        currentUser.child("Users").setValue(user, new DatabaseReference.CompletionListener() {
                                            @Override
                                            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                                if (databaseError != null) {
                                                    Log.e("Error", databaseError.toString());
                                                }
                                            }

                                        });

                                        Toast.makeText(Signup.this, "SignUp successful", Toast.LENGTH_LONG).show();

                                        startActivity(new Intent(Signup.this, TabActivity.class));
                                        finish();


                                    } else {
                                        Log.e("Print", task.getException().toString());
                                        Toast.makeText(Signup.this, "SignUp not successful", Toast.LENGTH_LONG).show();

                                    }
                                    progressBar.setVisibility(View.GONE);

                                }
                            });


                }


            }

            ;


        });
    }
}
