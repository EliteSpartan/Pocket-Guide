package com.chiller.apps.materialtest;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by Anthony on 1/06/2015.
 */
public class PrefsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);

        /*Preference cameron = findPreference("cameron");
        cameron.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                Intent cameron = new Intent(getActivity(), Cameron.class);
                startActivity(cameron);

                return true;
            }
        });*/
    }
}
