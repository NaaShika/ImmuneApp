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
import com.tutorial.aurie.finalyearproject.AddChild;
import com.tutorial.aurie.finalyearproject.ChatMessage;
import com.tutorial.aurie.finalyearproject.ChildListNew;
import com.tutorial.aurie.finalyearproject.ChldView;
import com.tutorial.aurie.finalyearproject.Objects.ChildMessage;
import com.tutorial.aurie.finalyearproject.R;

import java.util.List;

/**
 * Created by aurie on 07/04/2017.
 */

public class GridAdapter extends ArrayAdapter<ChildMessage>{
    private List<ChildMessage> childMessages;
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

        ChildMessage childMessage = childMessages.get(position);
        TextView textViewName = (TextView) convertView.findViewById(R.id.gridviewName);
        TextView textViewAge = (TextView)convertView.findViewById(R.id.gridviewAge);
        TextView textViewGender = (TextView)convertView.findViewById(R.id.gridviewGender);
        Button buttonAddChild = (Button) convertView.findViewById(R.id.buttonAddChild);
        final ImageView imageViewProfilePic = (ImageView) convertView.findViewById(R.id.gridviewImage);

        textViewAge.setText(childMessage.getAge());
        textViewName.setText(childMessage.getChildName());
        textViewGender.setText(childMessage.getGender());
        /** imageViewProfilePic.setImageResource(childMessage.getProfileImage());//
         *
         */
        Ion.with(context)
                .load(childMessage.getProfileImage())
                .asBitmap()
                .setCallback(new FutureCallback<Bitmap>() {
                    @Override
                    public void onCompleted(Exception e, Bitmap result) {
                        if (e == null && result!= null){
                            imageViewProfilePic.setImageBitmap(result);
                        }
                    }
                });

        buttonAddChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, AddChild.class));

            }
        });

        return convertView;
    }

    public GridAdapter(@NonNull Activity context, @LayoutRes int resource, List<ChildMessage> childMessages) {
        super(context, resource);
        this.childMessages = childMessages;
        this.context = context;
        this.resource = resource;
    }
}
