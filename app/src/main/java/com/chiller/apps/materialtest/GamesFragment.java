package com.chiller.apps.materialtest;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chiller.apps.materialtest.Adapter.GamesAdapter;

/**
 * Created by Anthony on 22/12/2014.
 */
public class GamesFragment extends Fragment {

    RecyclerView mRecyclerView;
    Activity context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_games, parent, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.grid_list_games);
        mRecyclerView.hasFixedSize();
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), setColumns(180)));

        String[] mTitles = {
                "Minecraft PC",
                "Minecraft PE",
                "Minecraft Xbox 360",
                "Minecraft PlayStation 3"
        }; // Titles
        Integer[] mImageID = {
                R.drawable.minecraft_pc,
                R.drawable.minecraft_pe,
                R.drawable.minecraft_x360,
                R.drawable.minecraft_ps3
        }; // Images
        GamesAdapter adapter = new GamesAdapter(mTitles, mImageID); // Passes the information to the adapter
        mRecyclerView.setAdapter(adapter);
    }

    // Dynamically gets sets the width of the columns for the Recycler View
    public int setColumns(int width) {

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = getResources().getDisplayMetrics().density;
        float dpWidth = outMetrics.widthPixels / density;

        return Math.round(dpWidth / width);
    }
}
