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

                if(item.getItemId() == R.id.menuProfile){
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new ProfileFragment());
                    fragmentTransaction.commit();
                }
                else if (item.getItemId() == R.id.menuSchedule){
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new ScheduleFragment());
                    fragmentTransaction.commit();
                }
                else if (item.getItemId() == R.id.menuRecords){
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new RecordsFragment());
                    fragmentTransaction.commit();
                }
                else if (item.getItemId() == R.id.menuCategories){
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new CategoriesFragment());
                    fragmentTransaction.commit();
                }
                else if (item.getItemId() == R.id.menuAboutUs){
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new AboutUsFragment());
                    fragmentTransaction.commit();
                }
                else {
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
