package com.chiller.apps.materialtest.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.chiller.apps.materialtest.R;

/**
 * Created by Anthony on 26/03/2015.
 */
public class GamesAdapterld extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] mTitles;
    //private final Integer[] mImageID; // Add Later when images are ready

    public GamesAdapterld(Activity context, String[] mTitles) { // Integer[] mImageID // Add After Images are ready

        super(context, R.layout.fragment_games_item, mTitles);
        this.context = context;
        this.mTitles = mTitles;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View mItemView = inflater.inflate(R.layout.fragment_games_item, null, true);

        TextView title = (TextView) mItemView.findViewById(R.id.card_text);
        title.setText(mTitles[position]);

        return mItemView;
    }
}
