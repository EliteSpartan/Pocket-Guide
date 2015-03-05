package com.chiller.apps.materialtest.minecraft;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.chiller.apps.materialtest.R;
import com.chiller.apps.materialtest.TabAdapters.SlidingTabLayout;
import com.chiller.apps.materialtest.adapters.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MinecraftPC extends ActionBarActivity {

    Toolbar toolbar;
    SlidingTabLayout mSlidingTabs;
    ViewPager mViewPager;
    ViewPagerAdapter mViewPagerAdapter;

    String TABLE_NAME = "PC Decorations";
    String COLUMN_ONE = "id";
    String COLUMN_TWO = "Name";

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

        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mTitles, mTabs);
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
}
