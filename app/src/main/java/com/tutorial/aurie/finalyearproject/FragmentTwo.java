package com.tutorial.aurie.finalyearproject;

import android.os.*;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FragmentTwo extends Fragment{

    public FragmentTwo(){

    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_two, container, false);
        ListView listView =(ListView) view.findViewById(R.id.listView);

        Message messageOne = new Message(R.drawable.appdemoimage, "Pharrel Williams", "Some little info about who you are, Good work on the shot you posted", "10:09");
        Message messageTwo = new Message(R.drawable.appdemoimage, "leonard DiCaprio", "Some little info about who you are, Good work on the shot you posted", "10:09");
        Message messageThree = new Message(R.drawable.appdemoimage, "Sussie Williams", "You guessed right, i am related to Pharrel Williams", "10:09");
        List<Message> messages = new ArrayList<>();
        messages.add(messageOne);
        messages.add(messageTwo);
        messages.add(messageThree);

        ListShowAdapter listShowAdapter = new ListShowAdapter(getActivity(), R.layout.activity_list_show_assignment, messages);
        listView.setAdapter(listShowAdapter);

        return view;


    }
}
