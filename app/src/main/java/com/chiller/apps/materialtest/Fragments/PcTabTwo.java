package com.chiller.apps.materialtest.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.chiller.apps.materialtest.GamesFragment;
import com.chiller.apps.materialtest.QuickReturn.QuickReturnListViewOnScrollListener;
import com.chiller.apps.materialtest.QuickReturn.QuickReturnRecyclerViewOnScrollListener;
import com.chiller.apps.materialtest.R;
import com.chiller.apps.materialtest.SQLiteHelper;

/**
 * Created by Anthony on 25/03/2015.
 */
public class PcTabTwo extends Fragment {

    Activity mActivity;
    SQLiteHelper dbHelper;
    RecyclerView mRecycler;
    Bundle bundle;
    int mColumns;

    protected QuickReturnRecyclerViewOnScrollListener onScrollListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState){

        View view = inflater.inflate(R.layout.pc_building_blocks, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();

        mRecycler = (RecyclerView) getActivity().findViewById(R.id.grid_list_deco);
        mRecycler.hasFixedSize();
        mRecycler.setLayoutManager(new GridLayoutManager(mActivity, mColumns));
    }
}
