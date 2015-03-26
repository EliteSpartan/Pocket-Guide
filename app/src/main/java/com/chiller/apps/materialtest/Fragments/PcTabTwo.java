package com.chiller.apps.materialtest.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.chiller.apps.materialtest.QuickReturn.QuickReturnListViewOnScrollListener;
import com.chiller.apps.materialtest.R;
import com.chiller.apps.materialtest.SQLiteHelper;

/**
 * Created by Anthony on 25/03/2015.
 */
public class PcTabTwo extends Fragment {

    Activity mActivity;
    SQLiteHelper dbHelper;
    GridView mGridView;
    Bundle bundle;

    protected QuickReturnListViewOnScrollListener mScrollListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState){

        View view = inflater.inflate(R.layout.pc_building_blocks, container, false);
        return view;
    }
}
