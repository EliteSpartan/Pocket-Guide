package com.chiller.apps.materialtest.minecraft;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chiller.apps.materialtest.Adapter.ViewPagerAdapter;
import com.chiller.apps.materialtest.R;
import com.chiller.apps.materialtest.TabAdapters.SlidingTabLayout;

public class MinecraftPC extends ActionBarActivity {

    Toolbar toolbar;
    SlidingTabLayout mSlidingTabs;
    ViewPager mViewPager;
    ViewPagerAdapter mViewPagerAdapter;
    RelativeLayout mToolbarLayout;

    int mTabs = 10;
    CharSequence mTitles[] = {
            "Building Blocks",
            "Decoration Blocks",
            "Redstone",
            "Transportation",
            "Foodstuffs",
            "Tools",
            "Combat",
            "Brewing",
            "Materials",
            "Miscellaneous"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minecraft_pc);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        // Sets the Back Arrow in the Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mToolbarLayout = (RelativeLayout) findViewById(R.id.toolbar_layout);
        int toolbarHeight = toolbar.getMeasuredHeight();
        int mToolbarLayoutHeight = mToolbarLayout.getMeasuredHeight();

        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mTitles, mTabs, toolbarHeight);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mViewPagerAdapter);

        mSlidingTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        mSlidingTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        mSlidingTabs.setViewPager(mViewPager);

    }

    public int setColumns(int width) {

        Display display = this.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = getResources().getDisplayMetrics().density;
        float dpWidth = outMetrics.widthPixels / density;

        return Math.round(dpWidth / width);
    }
}
