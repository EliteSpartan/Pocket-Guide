package com.chiller.apps.materialtest.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chiller.apps.materialtest.R;

public class DrawerList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] text;
    private final Integer[] imageId;

    public DrawerList(Activity context, String[] text, Integer[] imageId) {

        super(context, R.layout.drawer_list_item, text);
        this.context = context;
        this.text = text;
        this.imageId = imageId;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.drawer_list_item, null, true);

        // Titles
        TextView title = (TextView) rowView.findViewById(R.id.text);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);

        title.setText(text[position]);
        imageView.setImageResource(imageId[position]);

        return rowView;
    }

}
