package com.tutorial.aurie.finalyearproject.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutorial.aurie.finalyearproject.Objects.Message;
import com.tutorial.aurie.finalyearproject.R;

import java.util.List;

/**
 * Created by aurie on 09/03/2017.
 */

public class ListShowAdapter extends ArrayAdapter<Message>{

    private Activity context;
    private int resource;
    private List<Message> messages;


    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            convertView = layoutInflater.inflate(resource,parent,false);
        }
        Message message =messages.get(position);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.profileImage);
        TextView textView = (TextView)convertView.findViewById(R.id.senderName);
        textView.setText(message.getSenderName());

        return convertView;
    }

    public ListShowAdapter(Activity context, int resource, List<Message> messageList) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.messages = messageList;
    }

}
