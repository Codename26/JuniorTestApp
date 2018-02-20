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

public class DocsFragment extends Fragment {
    private String mDocs;
    private String mDate;

    public static DocsFragment newInstance(LogData logData){
        DocsFragment docsFragment = new DocsFragment();

        Bundle args = new Bundle();
        args.putString(Constants.DOCS, logData.getDocs());
        args.putString(Constants.DATE, logData.getDate());
        docsFragment.setArguments(args);

        return docsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDocs = getArguments().getString(Constants.DOCS);
        mDate = getArguments().getString(Constants.DATE);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_docs, container, false);
        ListView lv = v.findViewById(R.id.docsList);
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
            list.add(mDate + " " + mDocs + i);
        }
        return list;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        if (menu.size() > 0 ) {
            menu.getItem(2).setVisible(true);
        }
    }
}
