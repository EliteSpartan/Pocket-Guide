package com.chiller.apps.materialtest;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Anthony on 31/05/2015.
 */
public class PrefsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.preference_layout);

        if (savedInstanceState == null) {

            getFragmentManager().beginTransaction()
                    .add(R.id.content_wrapper, new PrefsFragment())
                    .commit();

        }


    }
}
