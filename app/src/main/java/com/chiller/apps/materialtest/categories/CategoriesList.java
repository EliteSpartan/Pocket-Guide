package com.chiller.apps.materialtest.categories;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chiller.apps.materialtest.R;

/**
 * Created by Anthony on 9/02/2015.
 */
public class CategoriesList extends ArrayAdapter<String> {

    private final Activity mContext;
    private final String[] mTitle;
    private final String[] mDesc;
    private final Integer[] mImageId;

    public CategoriesList(Activity mContext, String[] mTitle, String[] mDesc, Integer[] mImageId) {

        super(mContext, R.layout.categories_item, mTitle);

        this.mContext = mContext;
        this.mTitle = mTitle;
        this.mDesc = mDesc;
        this.mImageId = mImageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = mContext.getLayoutInflater();
        View mRow = inflater.inflate(R.layout.categories_item, null, true);

        ImageView mIconView = (ImageView) mRow.findViewById(R.id.row_img);
        TextView mTitleView = (TextView) mRow.findViewById(R.id.row_title);
        TextView mDescView = (TextView) mRow.findViewById(R.id.row_desc);

        mIconView.setImageResource(mImageId[position]);
        mTitleView.setText(mTitle[position]);
        mDescView.setText(mDesc[position]);

        return mRow;

    }
}
