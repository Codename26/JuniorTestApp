package com.codename26.juniortestapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.codename26.juniortestapplication.adapters.ScreenSlidePagerAdapter;
import com.codename26.juniortestapplication.model.LogData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ViewPager mPager;
    private ArrayList<LogData> mData;
    private TabLayout mTabLayout;
    private int mCurrentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabs();
        mData = initData();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setActionBarTitle( mData.get(0).getDate());

        mPager = findViewById(R.id.mainPager);
        ScreenSlidePagerAdapter adapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), mData);
        mPager.setAdapter(adapter);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
               setActionBarTitle( mData.get(mPager.getCurrentItem()).getDate());
                mCurrentPage = mPager.getCurrentItem();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private ArrayList<LogData> initData() {
        ArrayList<LogData> data = new ArrayList<>();
        for (int i = 0; i < Constants.PAGE_COUNT; i++) {
            data.add(new LogData("February " + (i + 10),"LOG" + i,
                    "General" + i, "Docs" +i, "DVIR" + i));
        }
        return data;
    }


    public void dateOnClickListener(View v){
        switch (v.getId()){
            case R.id.imageArrowPrev :
            case R.id.tvPreviousLog :
                if (mPager.getCurrentItem() - 1 > -1) {
                    mPager.setCurrentItem(mPager.getCurrentItem() - 1);
                } else Toast.makeText(MainActivity.this, R.string.first_page_warning, Toast.LENGTH_SHORT)
                .show();
                break;

            case R.id.imageArrowNext :
            case R.id.tvNextLog :
                if (mPager.getCurrentItem() + 1 < mPager.getAdapter().getCount()) {
                    mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                } else Toast.makeText(MainActivity.this, R.string.last_page_warning, Toast.LENGTH_SHORT)
                        .show();
                break;
        }
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void initTabs() {
        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.addTab(mTabLayout.newTab().setText("Log"));
        mTabLayout.addTab(mTabLayout.newTab().setText("General"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Docs"));
        mTabLayout.addTab(mTabLayout.newTab().setText("DVIR"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    public TabLayout getTabLayout(){
        return mTabLayout;
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mCurrentPage == 0) {
            super.onBackPressed();
        }
        mPager.setCurrentItem(mCurrentPage - 1);
    }
}
