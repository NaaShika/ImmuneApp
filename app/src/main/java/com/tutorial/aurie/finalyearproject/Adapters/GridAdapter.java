package com.tutorial.aurie.finalyearproject.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.tutorial.aurie.finalyearproject.ChatMessage;
import com.tutorial.aurie.finalyearproject.ChildListNew;
import com.tutorial.aurie.finalyearproject.ChldView;
import com.tutorial.aurie.finalyearproject.Objects.Child;
import com.tutorial.aurie.finalyearproject.Objects.ChildMessage;
import com.tutorial.aurie.finalyearproject.R;
import com.tutorial.aurie.finalyearproject.ToolbarActivities.Schedule;

import java.util.List;

/**
 * Created by aurie on 07/04/2017.
 */

public class GridAdapter extends ArrayAdapter<Child>{
    private List<Child> childMessages;
    private Activity context;
    private int resource;

    @Override
    public int getCount() {
        return childMessages.size();
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            convertView = layoutInflater.inflate(resource, parent, false);
        }

        final Child childMessage = childMessages.get(position);
        TextView textViewName = (TextView) convertView.findViewById(R.id.gridviewName);
        TextView textViewAge = (TextView)convertView.findViewById(R.id.gridviewAge);
        TextView textViewGender = (TextView)convertView.findViewById(R.id.gridviewGender);
        Button buttonAddChild = (Button) convertView.findViewById(R.id.buttonAddChild);
        final ImageView imageViewProfilePic = (ImageView) convertView.findViewById(R.id.gridviewImage);

        textViewAge.setText(childMessage.age);
        textViewName.setText(childMessage.childName);
        textViewGender.setText(childMessage.gender);
        /** imageViewProfilePic.setImageResource(childMessage.getProfileImage());//
         *
         */

        buttonAddChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Schedule.class);
                intent.putExtra("Id",childMessage.ID);
                intent.putExtra("Name",childMessage.childName);
                intent.putExtra("Email",childMessage.parentEmail);
                context.startActivity(intent);

            }
        });

        Ion.with(context)
                .load(childMessage.profileImage)
                .asBitmap()
                .setCallback(new FutureCallback<Bitmap>() {
                    @Override
                    public void onCompleted(Exception e, Bitmap result) {
                        if (e == null && result!= null){
                            imageViewProfilePic.setImageBitmap(result);
                        }
                    }
                });



        return convertView;
    }

    public GridAdapter(@NonNull Activity context, @LayoutRes int resource, List<Child> childMessages) {
        super(context, resource);
        this.childMessages = childMessages;
        this.context = context;
        this.resource = resource;
    }
}
