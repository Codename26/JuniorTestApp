package com.codename26.juniortestapplication.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.codename26.juniortestapplication.fragments.containerFragments.DVIRFragment;
import com.codename26.juniortestapplication.fragments.containerFragments.DocsFragment;
import com.codename26.juniortestapplication.fragments.containerFragments.GeneralFragment;
import com.codename26.juniortestapplication.fragments.containerFragments.LogFragment;
import com.codename26.juniortestapplication.model.LogData;

public class FragmentContainerPagerAdapter extends FragmentStatePagerAdapter {
    private final int mNumOfTabs;
    private LogData mLogData;

    public FragmentContainerPagerAdapter(FragmentManager fm, int numOfTabs, LogData logData) {
        super(fm);
        mNumOfTabs = numOfTabs;
        mLogData = logData;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                LogFragment logFragmentTab = LogFragment.newInstance(mLogData);
                return logFragmentTab;
            case 1:
                GeneralFragment generalFragmentTab = GeneralFragment.newInstance(mLogData);
                return generalFragmentTab;
            case 2:
                DocsFragment docsFragmentTab = DocsFragment.newInstance(mLogData);
                return docsFragmentTab;
            case 3:
                DVIRFragment dvirFragmentTab = DVIRFragment.newInstance(mLogData);
                return dvirFragmentTab;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
