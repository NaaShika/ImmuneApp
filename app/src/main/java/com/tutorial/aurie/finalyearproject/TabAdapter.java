package com.tutorial.aurie.finalyearproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by aurie on 07/02/2017.
 */

public class TabAdapter extends FragmentPagerAdapter {


    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FragmentOne();
        } else if (position == 1) {
            return new FragmentTwo();
        } else {
            return new FragmentThree();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Read Me";
        } else if (position == 1) {
            return "Chats";
        } else {
            return "Schedule";
        }
    }
}