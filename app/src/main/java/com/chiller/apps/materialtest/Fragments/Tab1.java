package com.chiller.apps.materialtest.Fragments;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.chiller.apps.materialtest.R;
import com.chiller.apps.materialtest.SQLiteHelper;
import com.chiller.apps.materialtest.adapters.DrawerList;
import com.chiller.apps.materialtest.adapters.TabListAdapter;
import com.chiller.apps.materialtest.minecraft.MinecraftPC;

import java.util.ArrayList;

/**
 * Created by Anthony on 1/03/2015.
 */
public class Tab1 extends Fragment {

    Activity mContext;
    SQLiteHelper dbHelper;
    ListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState){

        View view = inflater.inflate(R.layout.tab1, container, false);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        mContext = getActivity();

        mListView = (ListView) getActivity().findViewById(R.id.list);

        // Initialises the SQLiteHelper Class
        dbHelper = new SQLiteHelper(getActivity());

        // Gets the Database
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<String> listNames = new ArrayList<>();

        // Query's the Database for the Values
        Cursor mCursor = db.query(DatabaseEntry.TABLE_NAME, new String[] {DatabaseEntry.COLUMN_NAME_TITLE},
                null, null, null, null, null, null);

        // Converts the Values from mCursor to an Array, 'listNames'
        for (mCursor.moveToFirst(); mCursor.moveToNext(); mCursor.isAfterLast()) {
            listNames.add(mCursor.getString(mCursor.getColumnIndex(DatabaseEntry.COLUMN_NAME_TITLE)));
        }

        // Gets the String values from the DB Array
        String[] mTitle = listNames.toArray(new String[listNames.size()]);
        TabListAdapter listAdapter = new TabListAdapter(mContext, mTitle); //mImage

        mListView.setAdapter(listAdapter);
        mCursor.close();
    }

    public static abstract class DatabaseEntry implements BaseColumns {

        public static final String TABLE_NAME = "PC_Build";
        public static final String COLUMN_NAME_TITLE = "Name";

    }
}
