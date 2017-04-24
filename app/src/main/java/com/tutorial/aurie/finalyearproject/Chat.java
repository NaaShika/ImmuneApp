package com.tutorial.aurie.finalyearproject;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.tutorial.aurie.finalyearproject.Adapters.DrProfileAdapter;
import com.tutorial.aurie.finalyearproject.Objects.DoctorProfileMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aurie on 30/01/2017.
 */

public class Chat extends AppCompatActivity{



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.chat);

        ListView listView = (ListView)findViewById(R.id.listViewDrProfile) ;

        DoctorProfileMessage doctorProfileMessageOne =  new DoctorProfileMessage(R.drawable.mother_child,"Dr Dzidzor Nutakor", "General Practitioner", "0249668268");
        DoctorProfileMessage doctorProfileMessageTwo =  new DoctorProfileMessage(R.drawable.mother_child,"Dr Charis Ashen", "Family Medicine",  "0208123045");
        DoctorProfileMessage doctorProfileMessageThree =  new DoctorProfileMessage(R.drawable.mother_child,"Dr Mavis Appau", "Urgent Care", "0244142073");

        List<DoctorProfileMessage> doctorProfileMessages =new ArrayList<>();
        doctorProfileMessages.add(doctorProfileMessageOne);
        doctorProfileMessages.add(doctorProfileMessageTwo);
        doctorProfileMessages.add(doctorProfileMessageThree);

        DrProfileAdapter drProfileAdapter = new DrProfileAdapter(Chat.this,R.layout.doctor_profile_view, doctorProfileMessages);
        listView.setAdapter(drProfileAdapter);

    }



}
