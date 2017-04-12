package com.tutorial.aurie.finalyearproject;

import android.os.*;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tutorial.aurie.finalyearproject.Adapters.ListShowAdapter;

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

        com.tutorial.aurie.finalyearproject.Objects.Message messageOne = new com.tutorial.aurie.finalyearproject.Objects.Message(R.drawable.appdemoimage, "Pharrel Williams", "Some little info about who you are, Good work on the shot you posted", "10:09");
        com.tutorial.aurie.finalyearproject.Objects.Message messageTwo = new com.tutorial.aurie.finalyearproject.Objects.Message(R.drawable.appdemoimage, "leonard DiCaprio", "Some little info about who you are, Good work on the shot you posted", "10:09");
        com.tutorial.aurie.finalyearproject.Objects.Message messageThree = new com.tutorial.aurie.finalyearproject.Objects.Message(R.drawable.appdemoimage, "Sussie Williams", "You guessed right, i am related to Pharrel Williams", "10:09");
        List<com.tutorial.aurie.finalyearproject.Objects.Message> messages = new ArrayList<>();
        messages.add(messageOne);
        messages.add(messageTwo);
        messages.add(messageThree);

        ListShowAdapter listShowAdapter = new ListShowAdapter(getActivity(), R.layout.activity_list_show_assignment, messages);
        listView.setAdapter(listShowAdapter);

        return view;


    }
}
