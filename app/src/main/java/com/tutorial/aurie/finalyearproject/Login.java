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

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_final_year);

        ImageView imageViewDemoImage = (ImageView) findViewById(R.id.imageViewAppDemoImage);
        final EditText editTextFullname = (EditText) findViewById(R.id.editTextFullname);
        final EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        final Button buttonLoginBtn = (Button) findViewById(R.id.buttonLoginBtn);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBarLogin);
        final TextView textViewShortcutToSignUp = (TextView) findViewById(R.id.textViewShortcutToSignUp);

        buttonLoginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String fullName = editTextFullname.getText().toString();
                String passWord = editTextPassword.getText().toString();

                if (fullName.isEmpty()) {
                    Toast.makeText(Login.this, "Please type your full name", Toast.LENGTH_LONG).show();
                    return;
                } else if (passWord.isEmpty()) {
                    Toast.makeText(Login.this, "Please type your preferred password", Toast.LENGTH_LONG).show();
                    return;
                } else if (passWord.length() < 5) {
                    Toast.makeText(Login.this, "Type a stronger password", Toast.LENGTH_LONG).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                buttonLoginBtn.setEnabled(false);
                String email = fullName + "@immune.com";

                mAuth.signInWithEmailAndPassword(email, passWord)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d("LoggedIn", "signInWithEmail:onComplete:" + task.isSuccessful());

                                progressBar.setVisibility(View.GONE);


                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (task.isSuccessful()) {

                                    Intent intent = new Intent(Login.this, TabActivity.class);
                                    startActivity(intent);

                                } else {
                                   Toast.makeText(Login.this,"not logged In", Toast.LENGTH_LONG).show();
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
