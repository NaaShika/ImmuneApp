package com.tutorial.aurie.finalyearproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.tutorial.aurie.finalyearproject.Adapters.GridAdapter;
import com.tutorial.aurie.finalyearproject.Objects.ChildMessage;
import com.tutorial.aurie.finalyearproject.ChildListNew;

/**
 * Created by aurie on 24/04/2017.
 */

public class ChildListNew extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_list);

        GridView gridView = (GridView) findViewById(R.id.GridViewOne);

        ChildMessage childMessage = new ChildMessage();


        GridAdapter gridAdapter = new GridAdapter(ChildListNew.this, R.layout.gridview, childMessage.retrieveAll());
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
