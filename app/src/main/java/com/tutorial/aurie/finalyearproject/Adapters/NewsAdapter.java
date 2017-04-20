package com.tutorial.aurie.finalyearproject.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tutorial.aurie.finalyearproject.Objects.NewsObject;
import com.tutorial.aurie.finalyearproject.R;

import java.util.List;

/**
 * Created by aurie on 20/04/2017.
 */

public class NewsAdapter extends ArrayAdapter<NewsObject> {

    private Activity context;
    private int resource;
    private List<NewsObject> newsObjects;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            convertView = layoutInflater.inflate(resource,parent,false);
        }
        NewsObject newsObject = getItem(position);
        TextView textViewTitle =(TextView) convertView.findViewById(R.id.textviewTitle);
        TextView textViewTime =(TextView) convertView.findViewById(R.id.textviewTime);
        TextView textViewDate =(TextView) convertView.findViewById(R.id.textviewDate);

        textViewDate.setText(textViewDate.getText());
        textViewTime.setText(textViewTime.getText());
        textViewTitle.setText(textViewTitle.getText());


        return convertView;

    }

    public NewsAdapter(Activity context, int resource, List<NewsObject> newsObjectList){
        super(context, resource);
        this.context =context;
        this.resource =resource;
    }

}