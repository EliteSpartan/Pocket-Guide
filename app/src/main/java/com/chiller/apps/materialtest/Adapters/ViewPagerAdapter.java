package com.chiller.apps.materialtest.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.chiller.apps.materialtest.Fragments.Exception;
import com.chiller.apps.materialtest.Fragments.PcTabOne;

/**
 * Created by Anthony on 1/03/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[];
    int NumbOfTabs;

    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabs) {

        super(fm);

        this.NumbOfTabs = mNumbOfTabs;
        this.Titles = mTitles;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            PcTabOne pcTabOne = new PcTabOne();
            return pcTabOne;
        }
        else {
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
