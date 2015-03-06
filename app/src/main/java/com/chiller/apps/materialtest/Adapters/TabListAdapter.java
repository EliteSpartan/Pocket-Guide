package com.chiller.apps.materialtest.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.chiller.apps.materialtest.R;

public class TabListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] title;
    //private final Integer[] mImage;

    public TabListAdapter(Activity context, String[] title) { //Integer[] mImage

        //super(mContext, R.layout.list_item, mTitle);
        super(context, R.layout.list_item, title);
        this.context = context;
        this.title = title;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View mview = inflater.inflate(R.layout.list_item, null, true);

        TextView textView = (TextView) mview.findViewById(R.id.text_title);
        textView.setText(title[position]);

        //ImageView imageView = (ImageView) mView.findViewById(R.id.img);
        //imageView.setImageResource(mImage[position]);

        return mview;
    }
}
