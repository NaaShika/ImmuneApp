package com.tutorial.aurie.finalyearproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tutorial.aurie.finalyearproject.Adapters.GridAdapter;
import com.tutorial.aurie.finalyearproject.Adapters.ScheduleViewAdapter;
import com.tutorial.aurie.finalyearproject.Objects.ScheduleDoseObject;

import java.util.ArrayList;
import java.util.List;

public class ScheduleListShow extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private List<ScheduleDoseObject> scheduleDoseObjects;
    private String parentNumber, childId;
    private ListView listView;
    private ScheduleViewAdapter scheduleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_list_show);

        scheduleDoseObjects = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listViewDrProfile);

        parentNumber = getIntent().getStringExtra("Email");
        childId = getIntent().getStringExtra("Id");
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Schedules");
        DatabaseReference currentParent = databaseReference.child(parentNumber);
        currentParent.child(childId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    ScheduleDoseObject scheduleDoseObject = dataSnapshot1.getValue(ScheduleDoseObject.class);
                    scheduleDoseObjects.add(scheduleDoseObject);
                    scheduleViewAdapter.notifyDataSetChanged();
                    Log.e("VaccineName", "onDataChange: " + scheduleDoseObject.VaccineName );

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        Log.e("VaccineName", "onDataChange: " + String.valueOf(scheduleDoseObjects.size()) );

        scheduleViewAdapter = new ScheduleViewAdapter(ScheduleListShow.this, R.layout.schedule_view,scheduleDoseObjects);
        listView.setAdapter(scheduleViewAdapter);


    }
}
