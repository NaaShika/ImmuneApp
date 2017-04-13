package com.tutorial.aurie.finalyearproject.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tutorial.aurie.finalyearproject.R;

/**
 * Created by aurie on 31/03/2017.
 */

public class ProfileFragment extends Fragment{    public ProfileFragment(){} //constructor in any class you need a constructor

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container,false);
        return view;
    }
}
