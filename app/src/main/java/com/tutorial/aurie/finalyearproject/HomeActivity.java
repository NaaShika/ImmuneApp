package com.tutorial.aurie.finalyearproject;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.tutorial.aurie.finalyearproject.ToolbarActivities.ChildList;
import com.tutorial.aurie.finalyearproject.ToolbarActivities.DoctorProfileFragment;
import com.tutorial.aurie.finalyearproject.ToolbarActivities.KnowledgeCentre;
import com.tutorial.aurie.finalyearproject.ToolbarActivities.Profile;
import com.tutorial.aurie.finalyearproject.ToolbarActivities.Records;
import com.tutorial.aurie.finalyearproject.ToolbarActivities.Schedule;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.homeToolBar);
        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.activity_home);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(HomeActivity.this, drawerLayout, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();

                if (item.getItemId() == R.id.menuProfile) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new Profile());
                    fragmentTransaction.commit();
                } else if (item.getItemId() == R.id.menuSchedule) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new Schedule());
                    fragmentTransaction.commit();
                } else if (item.getItemId() == R.id.menuRecords) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new Records());
                    fragmentTransaction.commit();
                } else if (item.getItemId() == R.id.menuKnowledgeCentre) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new KnowledgeCentre());
                    fragmentTransaction.commit();
                } else if (item.getItemId() == R.id.menuChildList) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new ChildList());
                    fragmentTransaction.commit();
                } else if (item.getItemId() == R.id.menuDDrProfile) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new DoctorProfileFragment());
                    fragmentTransaction.commit();
                } else {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new PrivacyPolicyFragment());
                    fragmentTransaction.commit();
                }
                return false;
            }
        });

        navigationView.getMenu().performIdentifierAction(R.id.menuProfile, 0);
    }
}
