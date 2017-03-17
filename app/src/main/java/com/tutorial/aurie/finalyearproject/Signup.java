package com.tutorial.aurie.finalyearproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ImageView imageViewDemoImage = (ImageView) findViewById(R.id.imageViewAppDemoImage);
        final EditText editTextFullname = (EditText) findViewById(R.id.editTextFullname);
        final EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        final EditText editTextPhoneNumber = (EditText) findViewById(R.id.editTextPhoneNumber);
        TextView textViewShortcutToLogin = (TextView) findViewById(R.id.textViewShortcutToLogIn);
        Button buttonSignUp = (Button) findViewById(R.id.buttonSignUp);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullName = editTextFullname.getText().toString();
                String phoneNumber = editTextPhoneNumber.getText().toString();
                String passWord = editTextPassword.getText().toString();

                Log.e("Print", "Something here");
                if (fullName.isEmpty()) {
                    Toast.makeText(Signup.this, "Please type your fullname", Toast.LENGTH_LONG).show();
                } else if (fullName.length() < 4) {
                    Toast.makeText(Signup.this, "Please enter a valid username", Toast.LENGTH_LONG).show();
                } else if (phoneNumber.length() < 10) {
                    Toast.makeText(Signup.this, "Please enter a complete phone number", Toast.LENGTH_LONG).show();
                } else if (phoneNumber.isEmpty()) {
                    Toast.makeText(Signup.this, "Please type your fullname", Toast.LENGTH_LONG).show();
                } else if (passWord.isEmpty()) {
                    Toast.makeText(Signup.this, "Please type your fullname", Toast.LENGTH_LONG).show();
                } else if (passWord.length() < 6) {
                    Toast.makeText(Signup.this, "Password not strong enough", Toast.LENGTH_LONG).show();
                } else {
                    Log.e("Print", "Can't figure it out");
                    startActivity(new Intent(Signup.this, TabActivity.class));
                }
            }


        });

        Log.e("Print", "But i'll get it");
        textViewShortcutToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(Signup.this, Login.class);
                startActivity(next);
            }
        });
    }
}
