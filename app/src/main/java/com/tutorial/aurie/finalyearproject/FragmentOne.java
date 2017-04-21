package com.tutorial.aurie.finalyearproject;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.tutorial.aurie.finalyearproject.Adapters.DrProfileAdapter;
import com.tutorial.aurie.finalyearproject.Adapters.NewsAdapter;
import com.tutorial.aurie.finalyearproject.Objects.DoctorProfileMessage;
import com.tutorial.aurie.finalyearproject.Objects.NewsObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends Fragment {

    public FragmentOne(){

    }
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_one, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listViewNews);

        NewsObject newsObjectOne = new NewsObject("Italy experiencing measles epidemic after fall-off in vaccinations","April 20,2017","8:21am");
        NewsObject newsObjectTwo = new NewsObject("Breast Cancer: Anatomy and early warning science","April 20,2017", "8:19am");
        NewsObject newsObjectThree = new NewsObject("Why is it a bad idea to space out your childs vaccination shots","April 20,2017", "8:14am");
        NewsObject newsObjectFour = new NewsObject("Bed bugs,how the hide and bite","April 20,2017", "8:01am");
        NewsObject newsObjectFive = new NewsObject("Crime, Human Rights and Vaccines","April 20,2017", "7:48am");
        NewsObject newsObjectSix = new NewsObject("Diabetes and Erectile Dysfuntion; ","April 19,2017", "6:00pm");
        NewsObject newsObjectSeven = new NewsObject("Are eggs healthy","April 19,2017", "5:05pm");
        NewsObject newsObjectEight = new NewsObject("Judge orders forced vaccinations for children in shocking UK cases","April 19,2017", "4:54");

        List<NewsObject> newsObjects = new ArrayList<>();
        newsObjects.add(newsObjectOne);
        newsObjects.add(newsObjectTwo);
        newsObjects.add(newsObjectThree);
        newsObjects.add(newsObjectFour);
        newsObjects.add(newsObjectFive);
        newsObjects.add(newsObjectSix);
        newsObjects.add(newsObjectSeven);
        newsObjects.add(newsObjectEight);

        NewsAdapter newsAdapter = new NewsAdapter(getActivity(),R.layout.information_view, newsObjects);
        listView.setAdapter(newsAdapter);


        return listView;
    }
}
