package com.codename26.juniortestapplication.fragments.containerFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.codename26.juniortestapplication.Constants;
import com.codename26.juniortestapplication.R;
import com.codename26.juniortestapplication.model.LogData;

import java.util.ArrayList;


public class DVIRFragment extends Fragment {
    private String mDvir;
    private String mDate;

    public static DVIRFragment newInstance(LogData logData){
        DVIRFragment dvirFragment = new DVIRFragment();

        Bundle args = new Bundle();
        args.putString(Constants.DVIR, logData.getDvir());
        args.putString(Constants.DATE, logData.getDate());
        dvirFragment.setArguments(args);

        return dvirFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDvir = getArguments().getString(Constants.DVIR);
        mDate = getArguments().getString(Constants.DATE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dvir, container, false);
        ListView lv = v.findViewById(R.id.dvirList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                generateList());
        lv.setAdapter(adapter);
        return v;
    }

    private ArrayList<String> generateList(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < Constants.LIST_ELEMENTS_NUMBER; i++) {
            list.add(mDate + " " + mDvir + i);
        }
        return list;
    }
}
