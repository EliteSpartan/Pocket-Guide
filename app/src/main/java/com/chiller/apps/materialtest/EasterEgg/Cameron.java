package com.chiller.apps.materialtest.EasterEgg;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.chiller.apps.materialtest.R;

/**
 * Created by Anthony on 1/06/2015.
 */
public class Cameron extends ActionBarActivity {

    Toolbar toolbar;
    TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.easter_egg_cameron);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTextView = (TextView) findViewById(R.id.tv);
    }
}
