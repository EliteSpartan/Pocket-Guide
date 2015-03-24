package com.chiller.apps.materialtest.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.chiller.apps.materialtest.Fragments.Exception;
import com.chiller.apps.materialtest.Fragments.PcTabOne;

/**
 * Created by Anthony on 1/03/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private final CharSequence Titles[];
    private final int NumbOfTabs;
    int mToolbarHeight;

    Bundle bundle;

    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabs, int mToolbarHeight) {

        super(fm);

        this.NumbOfTabs = mNumbOfTabs;
        this.Titles = mTitles;
        this.mToolbarHeight = mToolbarHeight;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {

            PcTabOne pcTabOne = new PcTabOne();
            bundle = new Bundle();

            bundle.putInt("ToolbarHeight", mToolbarHeight);
            pcTabOne.setArguments(bundle);
            return pcTabOne;

        } else {

            Exception exception = new Exception();
            return exception;

        }
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return Titles[position];
    }

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}
