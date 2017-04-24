package com.tutorial.aurie.finalyearproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tutorial.aurie.finalyearproject.Adapters.GridAdapter;
import com.tutorial.aurie.finalyearproject.Objects.Child;
import com.tutorial.aurie.finalyearproject.Objects.ChildMessage;
import com.tutorial.aurie.finalyearproject.ChildListNew;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aurie on 24/04/2017.
 */

public class ChildListNew extends AppCompatActivity {
private DatabaseReference databaseReference;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_list);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("ChildList");

        GridView gridView = (GridView) findViewById(R.id.GridViewOne);

        final List<Child> children = new ArrayList<>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //datasnapshot to retrieve the data from the table
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){

                    Child child = dataSnapshot1.getValue(Child.class);
                    children.add(child);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //String ID, String profileImage, String childName, String age, String gender

        GridAdapter gridAdapter = new GridAdapter(ChildListNew.this, R.layout.gridview,children);
        gridView.setAdapter(gridAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ChildListNew.this, ChldView.class);
                startActivity(intent);
            }
        });
    }


}
