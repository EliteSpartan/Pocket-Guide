package com.chiller.apps.materialtest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Anthony on 22/12/2014.
 */
public class PinnedFragment extends Fragment {

    public PinnedFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_pinned, container, false);

        return rootView;
    }
}
