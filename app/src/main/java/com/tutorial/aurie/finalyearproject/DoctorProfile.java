package com.tutorial.aurie.finalyearproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DoctorProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);

        TextView textView = (TextView) findViewById(R.id.textViewDocName);
        TextView textViewDocInfor = (TextView) findViewById(R.id.textViewDocInfor);
        TextView textViewMeetingTime = (TextView) findViewById(R.id.textViewMeetingTime);
        ImageView imageViewCallDr = (ImageView) findViewById(R.id.imageViewCallDr);
        ImageView imageViewEmailDr = (ImageView) findViewById(R.id.imageViewEmailDr);
    }
}
