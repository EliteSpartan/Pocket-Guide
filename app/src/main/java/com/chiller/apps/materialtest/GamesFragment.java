package com.chiller.apps.materialtest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Anthony on 22/12/2014.
 */
public class GamesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){

        return inflater.inflate(R.layout.fragment_games, parent, false);
        // return inflater.inflate(R.layout.fragment_games, parent, false);

    }
}
