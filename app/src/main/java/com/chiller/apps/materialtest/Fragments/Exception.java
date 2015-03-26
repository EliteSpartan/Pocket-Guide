package com.chiller.apps.materialtest.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chiller.apps.materialtest.R;

/**
 * Created by Anthony on 1/03/2015.
 */
public class Exception extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.exception, container, false);
        return view;
    }
}
