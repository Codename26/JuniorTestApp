package com.codename26.juniortestapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codename26.juniortestapplication.Constants;
import com.codename26.juniortestapplication.MainActivity;
import com.codename26.juniortestapplication.R;
import com.codename26.juniortestapplication.adapters.FragmentContainerPagerAdapter;
import com.codename26.juniortestapplication.model.LogData;
import com.codename26.juniortestapplication.viewPagers.LockableViewPager;



public class MainFragment extends Fragment {
    private LogData mLogData;
    private int mCurrentPage;
    private TabLayout mTabLayout;
    private LockableViewPager viewPager;


    public static MainFragment newInstance(LogData logData){
        MainFragment mainFragment = new MainFragment();

        Bundle args = new Bundle();
        args.putParcelable(Constants.LOG_DATA, logData);
        mainFragment.setArguments(args);

        return mainFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLogData = getArguments().getParcelable(Constants.LOG_DATA);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        viewPager = v.findViewById(R.id.pager);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        FragmentContainerPagerAdapter adapter = new FragmentContainerPagerAdapter(getChildFragmentManager(),
                Constants.TABS_COUNT, mLogData);
        mTabLayout = ((MainActivity)getActivity()).getTabLayout();
        mCurrentPage = mTabLayout.getSelectedTabPosition();
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(mCurrentPage);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mTabLayout = null;
        viewPager.clearOnPageChangeListeners();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        for (int i = 0; i < menu.size(); i++)
            menu.getItem(i).setVisible(false);
    }
}
