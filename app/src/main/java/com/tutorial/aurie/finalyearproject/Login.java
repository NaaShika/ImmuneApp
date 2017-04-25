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
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_final_year);

        ImageView imageViewDemoImage = (ImageView) findViewById(R.id.imageViewAppDemoImage);
        final EditText editTextFullname = (EditText) findViewById(R.id.editTextFullname);
        final EditText editTextPhoneNumber = (EditText) findViewById(R.id.editTextPhoneNumber);
        final EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        final Button buttonLoginBtn = (Button) findViewById(R.id.buttonLoginBtn);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBarLogin);
        final TextView textViewShortcutToSignUp = (TextView) findViewById(R.id.textViewShortcutToSignUp);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        buttonLoginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String phoneNumber= editTextPhoneNumber.getText().toString();
                String passWord = editTextPassword.getText().toString();

                if (phoneNumber.isEmpty()) {
                    Toast.makeText(Login.this, "Please type your full name", Toast.LENGTH_LONG).show();
                    return;
                } else if (passWord.isEmpty()) {
                    Toast.makeText(Login.this, "Please type your preferred password", Toast.LENGTH_LONG).show();
                    return;
                } else if (passWord.length() < 5) {
                    Toast.makeText(Login.this, "Type a stronger password", Toast.LENGTH_LONG).show();
                    return;
                }else {

                }

                progressBar.setVisibility(View.VISIBLE);
                buttonLoginBtn.setEnabled(false);
                final String email = phoneNumber + "@immune.com";

                mAuth.signInWithEmailAndPassword(email, passWord)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d("LoggedIn", "signInWithEmail:onComplete:" + task.isSuccessful());

                                progressBar.setVisibility(View.GONE);

                                if (task.isSuccessful()) {
                                    UserInfo userInfo = task.getResult().getUser();
                                    String email = userInfo.getEmail();
                                    String id = userInfo.getUid();

                                    Intent intent = new Intent(Login.this, TabActivity.class);
                                    startActivity(intent);

                                } else {
                                   Toast.makeText(Login.this,"Your credentials do not exist ", Toast.LENGTH_LONG).show();
                                }
                            }


            });

                textViewShortcutToSignUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent signupIntent = new Intent(Login.this, Signup.class);
                        startActivity(signupIntent);
                    }
                });

        }
    });

}
}
