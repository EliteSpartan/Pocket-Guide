package com.chiller.apps.materialtest.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chiller.apps.materialtest.R;

/**
 * Created by Anthony on 14/02/2015.
 */
public class CategoriesDetailAdapter extends ArrayAdapter<String> {

    private final Activity mContext;
    private final String[] mTitle;
    private final Integer[] mImageId;

    public CategoriesDetailAdapter(Activity mContext, String[] mTitle, Integer[] mImageId) {

        super(mContext, R.layout.categories_detail_item, mTitle);

        this.mContext = mContext;
        this.mTitle = mTitle;
        this.mImageId = mImageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = mContext.getLayoutInflater();
        View mRow = inflater.inflate(R.layout.categories_detail_item, null, true);

        ImageView mImageView = (ImageView) view.findViewById(R.id.detail_image);
        TextView mTextView = (TextView) view.findViewById(R.id.detail_title);

        mImageView.setImageResource(mImageId[position]);
        mTextView.setText(mTitle[position]);

        return mRow;
    }
}
