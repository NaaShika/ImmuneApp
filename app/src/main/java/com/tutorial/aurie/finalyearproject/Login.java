package com.tutorial.aurie.finalyearproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_final_year);

        ImageView imageViewDemoImage =(ImageView) findViewById(R.id.imageViewAppDemoImage);
        final EditText editTextFullname =(EditText) findViewById(R.id.editTextFullname);
        final EditText editTextPassword =(EditText) findViewById(R.id.editTextPassword);
        Button buttonLoginBtn =(Button) findViewById(R.id.buttonLoginBtn);
        TextView textViewShortcutToLogin =(TextView) findViewById(R.id.textViewShortcutToSignUp);

        buttonLoginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String fullName = editTextFullname.getText().toString();
                String passWord = editTextPassword.getText().toString();

                if (fullName.isEmpty()){
                    Toast.makeText(Login.this, "Please type your full name", Toast.LENGTH_LONG).show();
                }else if(passWord.isEmpty()){
                    Toast.makeText(Login.this, "Please type your preferred password",Toast.LENGTH_LONG).show();
                }else if (passWord.length() < 5){
                    Toast.makeText(Login.this, "Type a stronger password",Toast.LENGTH_LONG).show();
                }else {
                    startActivity(new Intent(Login.this, TabActivity.class));
                }
            }
        });

    }
}
