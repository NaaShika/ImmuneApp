package com.tutorial.aurie.finalyearproject;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by aurie on 07/04/2017.
 */

public class GridAdapter extends ArrayAdapter<ChildMessage>{
    private List<ChildMessage> messages;
    private Activity context;
    private int resource;


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    public GridAdapter(@NonNull Context context, @LayoutRes int resource, List<ChildMessage> messages, Activity context1, int resource1) {
        super(context, resource);
        this.messages = messages;
        this.context = context1;
        this.resource = resource1;
    }
}
