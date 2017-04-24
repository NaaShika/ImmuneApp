package com.tutorial.aurie.finalyearproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.tutorial.aurie.finalyearproject.Adapters.GridAdapter;
import com.tutorial.aurie.finalyearproject.Objects.ChildMessage;

public class ChildList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_list);


        GridView gridView = (GridView) findViewById(R.id.GridViewOne);

        ChildMessage childMessage = new ChildMessage();


        GridAdapter gridAdapter = new GridAdapter(ChildList.this, R.layout.gridview, childMessage.retrieveAll());
        gridView.setAdapter(gridAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ChildList.this, ChldView.class);
                startActivity(intent);
            }
        });


    }
}
