package com.tutorial.aurie.finalyearproject.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutorial.aurie.finalyearproject.Objects.ChildMessage;
import com.tutorial.aurie.finalyearproject.Objects.DoctorProfileMessage;
import com.tutorial.aurie.finalyearproject.R;
import com.tutorial.aurie.finalyearproject.RealmDatabase;

import java.util.List;

/**
 * Created by aurie on 13/04/2017.
 */

public class DrProfileAdapter extends ArrayAdapter<DoctorProfileMessage> {
    private List<DoctorProfileMessage> doctorProfileMessages;
    private Activity context;
    private int resource;

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

        textViewName.setText(doctorProfileMessage.getDoctorName());
        textViewSpeciality.setText(doctorProfileMessage.getSpeciality());
        imageViewProfilePic.setImageResource(doctorProfileMessage.getProfileImage());


        return convertView;
    }

    public DrProfileAdapter(@NonNull Context context, @LayoutRes int resource, List<DoctorProfileMessage> doctorProfileMessages) {
        super(context, resource);
    }
}
