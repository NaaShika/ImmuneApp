package com.tutorial.aurie.finalyearproject.ToolbarActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tutorial.aurie.finalyearproject.Adapters.DrProfileAdapter;
import com.tutorial.aurie.finalyearproject.Objects.DoctorProfileMessage;
import com.tutorial.aurie.finalyearproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aurie on 13/04/2017.
 */

public class DoctorProfileFragment extends Fragment{
    public DoctorProfileFragment(){}
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.doctor_profile_fragment,container,false);
        ListView listView = (ListView)view.findViewById(R.id.listViewDrProfile) ;

        DoctorProfileMessage doctorProfileMessageOne =  new DoctorProfileMessage(R.drawable.mother_child,"Dr Dzidzor Nutakor", "General Practitioner");
        DoctorProfileMessage doctorProfileMessageTwo =  new DoctorProfileMessage(R.drawable.mother_child,"Dr Charis Ashen", "Family Medicine");
        DoctorProfileMessage doctorProfileMessageThree =  new DoctorProfileMessage(R.drawable.mother_child,"Dr Mavis Appau", "Urgent Care");

        List<DoctorProfileMessage> doctorProfileMessages =new ArrayList<>();
        doctorProfileMessages.add(doctorProfileMessageOne);
        doctorProfileMessages.add(doctorProfileMessageTwo);
        doctorProfileMessages.add(doctorProfileMessageThree);

        DrProfileAdapter drProfileAdapter = new DrProfileAdapter(getActivity(),R.layout.doctor_profile_view, doctorProfileMessages);
        listView.setAdapter(drProfileAdapter);
        return view;

}}
