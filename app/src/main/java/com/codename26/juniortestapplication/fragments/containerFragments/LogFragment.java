package com.codename26.juniortestapplication.fragments.containerFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.codename26.juniortestapplication.Constants;
import com.codename26.juniortestapplication.R;
import com.codename26.juniortestapplication.model.LogData;

import java.util.ArrayList;


public class LogFragment extends Fragment {
    private String mLog;
    private String mDate;

    public static LogFragment newInstance(LogData logData){
        LogFragment logFragment = new LogFragment();

        Bundle args = new Bundle();
        args.putString(Constants.LOG, logData.getLog());
        args.putString(Constants.DATE, logData.getDate());
        logFragment.setArguments(args);

        return logFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLog = getArguments().getString(Constants.LOG);
        mDate = getArguments().getString(Constants.DATE);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_log, container, false);
        ListView lv = v.findViewById(R.id.logList);
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
            list.add(mDate + " " + mLog + i);
        }
        return list;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        if (menu.size() > 0 ) {
            menu.getItem(0).setVisible(true);
        }
    }
}
