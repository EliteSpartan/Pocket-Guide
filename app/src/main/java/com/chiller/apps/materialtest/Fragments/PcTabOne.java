package com.chiller.apps.materialtest.Fragments;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.chiller.apps.materialtest.Adapter.TabListAdapter;
import com.chiller.apps.materialtest.QuickReturn.QuickReturnListViewOnScrollListener;
import com.chiller.apps.materialtest.QuickReturn.QuickReturnViewType;
import com.chiller.apps.materialtest.R;
import com.chiller.apps.materialtest.SQLiteHelper;

import java.util.ArrayList;

/**
 * Created by Anthony on 1/03/2015.
 */
public class PcTabOne extends Fragment {

    Activity mActivity;
    SQLiteHelper dbHelper;
    GridView mGridView;
    Bundle bundle;
    int mLastFirstVisibleItem;

    protected QuickReturnListViewOnScrollListener mScrollListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState){

        View view = inflater.inflate(R.layout.pc_building_blocks, container, false);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        mActivity = getActivity();
        bundle = new Bundle();

        View mToolbarView = getActivity().findViewById(R.id.toolbar_layout);

        int mToolbarHeight = Math.round(getResources().getDimension(R.dimen.abc_action_bar_default_height_material));
        int mHeaderHeight = mToolbarView.getMeasuredHeight();

        mGridView = (GridView) getActivity().findViewById(R.id.list);
        mGridView.setPadding(mGridView.getPaddingLeft(),
                mGridView.getPaddingTop() + mHeaderHeight,
                    // Sets the padding for the top so the grid is under the toolbar
                mGridView.getPaddingRight(),
                mGridView.getPaddingBottom());

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
        TabListAdapter listAdapter = new TabListAdapter(mActivity, mTitle); //mImage

        mGridView.setAdapter(listAdapter);
        mCursor.close();

        mScrollListener = new QuickReturnListViewOnScrollListener.Builder(QuickReturnViewType.HEADER)
                .header(mToolbarView)
                .minHeaderTranslation(-mToolbarHeight)
                .isSnappable(true)
                .build();
        mGridView.setOnScrollListener(mScrollListener);
    }

    private static abstract class DatabaseEntry implements BaseColumns {

        public static final String TABLE_NAME = "PC_Build";
        public static final String COLUMN_NAME_TITLE = "Name";

    }
}
