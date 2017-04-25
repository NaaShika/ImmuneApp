package com.tutorial.aurie.finalyearproject.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.tutorial.aurie.finalyearproject.Objects.Child;
import com.tutorial.aurie.finalyearproject.Objects.ScheduleDose;
import com.tutorial.aurie.finalyearproject.Objects.ScheduleDoseObject;
import com.tutorial.aurie.finalyearproject.R;
import com.tutorial.aurie.finalyearproject.ToolbarActivities.Schedule;

import java.util.List;

/**
 * Created by aurie on 07/04/2017.
 */

public class ScheduleViewAdapter extends ArrayAdapter<ScheduleDoseObject>{
    private List<ScheduleDoseObject> scheduleDoses;
    private Activity context;
    private int resource;

    @Override
    public int getCount() {
        return  scheduleDoses.size();
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            convertView = layoutInflater.inflate(resource, parent, false);
        }

        final ScheduleDoseObject scheduleDose = scheduleDoses.get(position);
        TextView textviewDoseName = (TextView) convertView.findViewById(R.id.textviewDoseName);
        TextView textviewDose = (TextView)convertView.findViewById(R.id.textviewDose);
        TextView textviewDate = (TextView)convertView.findViewById(R.id.textviewDate);
        final ImageView doseImage = (ImageView) convertView.findViewById(R.id.doseImage);

        textviewDose.setText(scheduleDose.Dose);
        textviewDoseName.setText(scheduleDose.VaccineName);
        textviewDate.setText(scheduleDose.Date);

        return convertView;
    }

    public ScheduleViewAdapter(@NonNull Activity context, @LayoutRes int resource, List<ScheduleDoseObject> scheduleDoses) {
        super(context, resource);
        this.scheduleDoses = scheduleDoses;
        this.context = context;
        this.resource = resource;
    }
}
