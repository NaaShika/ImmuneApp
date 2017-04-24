package com.tutorial.aurie.finalyearproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.tutorial.aurie.finalyearproject.Adapters.TabAdapter;
import com.tutorial.aurie.finalyearproject.ToolbarActivities.Records;
import com.tutorial.aurie.finalyearproject.ToolbarActivities.Schedule;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout =(TabLayout) findViewById(R.id.tab);
        ViewPager viewPager =(ViewPager) findViewById(R.id.viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.addTab(tabLayout.newTab().setText("Information"));
        tabLayout.addTab(tabLayout.newTab().setText("Chat Me"));


        /**tabLayout.setupWithViewPager(viewPager);**/

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //setOnTabSelected is deprecated, better to use addOnTabSelectedListener but it's not working.
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.hometoolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuChildList){
            startActivity(new Intent(TabActivity.this, ChildListNew.class));
            return true;
        }

        else if (id == R.id.menuRecords){
            startActivity(new Intent(TabActivity.this, Records.class));
            return true;
        }
        else if (id == R.id.menuSchedule){
            startActivity(new Intent(TabActivity.this, Schedule.class));
            return true;
        }


        return super.onOptionsItemSelected(item);

    }
}
