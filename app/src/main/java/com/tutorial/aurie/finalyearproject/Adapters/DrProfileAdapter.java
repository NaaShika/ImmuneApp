package com.tutorial.aurie.finalyearproject.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutorial.aurie.finalyearproject.ChatMessage;
import com.tutorial.aurie.finalyearproject.DoctorProfile;
import com.tutorial.aurie.finalyearproject.Objects.ChildMessage;
import com.tutorial.aurie.finalyearproject.Objects.DoctorProfileMessage;
import com.tutorial.aurie.finalyearproject.R;
import com.tutorial.aurie.finalyearproject.RealmDatabase;

import java.util.List;
import java.util.jar.Manifest;

/**
 * Created by aurie on 13/04/2017.
 */

public class DrProfileAdapter extends ArrayAdapter<DoctorProfileMessage> {


    private List<DoctorProfileMessage> doctorProfileMessages;
    private Activity context;
    private int resource;

    @Override
    public int getCount() {
        return doctorProfileMessages.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            convertView = layoutInflater.inflate(resource, parent, false);
        }

        DoctorProfileMessage doctorProfileMessage = doctorProfileMessages.get(position);
        TextView textViewName = (TextView)convertView.findViewById(R.id.textviewDrName);
        TextView textViewSpeciality = (TextView)convertView.findViewById(R.id.textviewSpeciality);
        ImageView imageViewProfilePic = (ImageView) convertView.findViewById(R.id.rectangleImageView);
        ImageView imageViewChatImage = (ImageView) convertView.findViewById(R.id.imageViewChatImage);
        ImageView imageViewCallDr = (ImageView) convertView.findViewById(R.id.imageViewCallDr);

        textViewName.setText(doctorProfileMessage.getDoctorName());
        textViewSpeciality.setText(doctorProfileMessage.getSpeciality());
        imageViewProfilePic.setImageResource(doctorProfileMessage.getProfileImage());



        imageViewChatImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ChatMessage.class));
            }
        });

        imageViewCallDr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });



        return convertView;
    }



    public DrProfileAdapter(@NonNull Activity context, @LayoutRes int resource, List<DoctorProfileMessage> doctorProfileMessages) {
        super(context, resource);
        this.doctorProfileMessages = doctorProfileMessages;
        this.context = context;
        this.resource = resource;
    }
}
