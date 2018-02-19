package com.codename26.juniortestapplication.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.codename26.juniortestapplication.fragments.containerFragments.DVIRFragment;
import com.codename26.juniortestapplication.fragments.containerFragments.DocsFragment;
import com.codename26.juniortestapplication.fragments.containerFragments.GeneralFragment;
import com.codename26.juniortestapplication.fragments.containerFragments.LogFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                LogFragment logFragmentTab = new LogFragment();
                return logFragmentTab;
            case 1:
                GeneralFragment generalFragmentTab = new GeneralFragment();
                return generalFragmentTab;
            case 2:
                DocsFragment docsFragmentTab = new DocsFragment();
                return docsFragmentTab;
            case 3:
                DVIRFragment dvirFragmentTab = new DVIRFragment();
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
