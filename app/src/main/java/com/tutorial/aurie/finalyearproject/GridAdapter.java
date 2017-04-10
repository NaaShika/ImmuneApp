package com.tutorial.aurie.finalyearproject;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aurie on 07/04/2017.
 */

public class GridAdapter extends ArrayAdapter<ChildMessage>{
    private List<ChildMessage> childMessages;
    private Activity context;
    private int resource;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            convertView = layoutInflater.inflate(resource, parent, false);
        }

        ChildMessage childMessage = childMessages.get(position);
        TextView textViewName = (TextView) convertView.findViewById(R.id.gridviewName);
        TextView textViewAge = (TextView)convertView.findViewById(R.id.gridviewAge);
        TextView textViewGender = (TextView)convertView.findViewById(R.id.gridviewGender);
        ImageView imageViewProfilePic = (ImageView) convertView.findViewById(R.id.gridviewImage);

        textViewAge.setText(childMessage.getAge());
        textViewName.setText(childMessage.getChildName());
        textViewGender.setText(childMessage.getGender());
        imageViewProfilePic.setImageResource(childMessage.getProfileImage());

        return convertView;
    }

    public GridAdapter(@NonNull Context context, @LayoutRes int resource, List<ChildMessage> childMessages, Activity context1, int resource1) {
        super(context, resource);
        this.childMessages = childMessages;
        this.context = context1;
        this.resource = resource1;
    }
}
