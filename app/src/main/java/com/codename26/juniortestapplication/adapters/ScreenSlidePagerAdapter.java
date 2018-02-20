package com.codename26.juniortestapplication.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.codename26.juniortestapplication.fragments.MainFragment;
import com.codename26.juniortestapplication.model.LogData;

import java.util.ArrayList;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<LogData> mLogData;

    public ScreenSlidePagerAdapter(FragmentManager fm, ArrayList<LogData> data) {
        super(fm);
        mLogData = data;
    }

    @Override
    public Fragment getItem(int position) {
        return MainFragment.newInstance(mLogData.get(position));
    }

    @Override
    public int getCount() {
        return mLogData.size();

    }
}
