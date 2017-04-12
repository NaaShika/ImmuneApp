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


public class Signup extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();

        ImageView imageViewDemoImage = (ImageView) findViewById(R.id.imageViewAppDemoImage);
        final EditText editTextFullname = (EditText) findViewById(R.id.editTextFullname);
        final EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        final EditText editTextPhoneNumber = (EditText) findViewById(R.id.editTextPhoneNumber);
        TextView textViewShortcutToLogin = (TextView) findViewById(R.id.textViewShortcutToLogIn);
        final Button buttonSignUp = (Button) findViewById(R.id.buttonSignUp);
        final ProgressBar progressBar =(ProgressBar) findViewById(R.id.progressBar);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullName = editTextFullname.getText().toString();
                String phoneNumber = editTextPhoneNumber.getText().toString();
                String passWord = editTextPassword.getText().toString();

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
                }else {
                        startActivity(new Intent(Signup.this, HomeActivity.class));
                }

                Log.e("Print","running");

                progressBar.setVisibility(View.VISIBLE);
                // to disable the button
                buttonSignUp.setEnabled(false);
                Log.e("Print","checking");

                String email = phoneNumber + "@immune.com";


               /** mAuth.createUserWithEmailAndPassword(email, passWord)
                        .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // to enable the button again --true
                                buttonSignUp.setEnabled(true);
                                progressBar.setVisibility(View.GONE);
                                Log.d("Served", "createUserWithEmail:onComplete:" + task.isSuccessful());

                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.

                                Log.e("Print","how about here");

                                if (!task.isSuccessful()) {
                                    Toast.makeText(Signup.this,"Failed to create account. Try again",Toast.LENGTH_SHORT).show();
                                }else {
                                    Log.e("Print", "Can't figure it out");
                                    startActivity(new Intent(Signup.this, TabActivity.class));
                                }

                            }
                        } ); **/

            }


        });

        Log.e("Print", "But i'll get it");
        textViewShortcutToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
