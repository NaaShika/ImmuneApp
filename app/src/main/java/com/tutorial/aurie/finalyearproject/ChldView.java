package com.tutorial.aurie.finalyearproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

public class ChldView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chld_view);

        ImageView imageView =(ImageView) findViewById(R.id.profileImageChild);
        EditText editTextName =(EditText) findViewById(R.id.editTextChildName);
        EditText editTextAge =(EditText) findViewById(R.id.editTextChildAge);
        EditText editTextDOB =(EditText) findViewById(R.id.editTextChildDOB);
        EditText editTextParentNumber=(EditText) findViewById(R.id.editTextParentNumber);
        EditText editTextParentEmail=(EditText) findViewById(R.id.editTextParentEmail);
        CheckBox checkBoxFemale =(CheckBox) findViewById(R.id.checkboxFemale);
        CheckBox checkBoxMale =(CheckBox) findViewById(R.id.checkboxMale);
        CheckBox checkBoxNotification =(CheckBox) findViewById(R.id.checkboxNotification);
        Button buttonSaveChild = (Button)findViewById(R.id.buttonSaveChild);

    }
}
