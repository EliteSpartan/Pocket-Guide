package com.chiller.apps.materialtest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.chiller.apps.materialtest.adapters.CategoriesDetailAdapter;

public class CategoriesDetailList extends ActionBarActivity {

    ListView mListView;

    String[] mTitles;
    Integer[] mImageId = {
            R.drawable.ic_launcher
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_detail_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // Initializes the Toolbar
        if (toolbar != null) {
            setSupportActionBar(toolbar); // Adds the toolbar if it has not been created
        }

        String title = getIntent().getStringExtra("title");
        //Integer itemNumber = getIntent().getIntExtra("itemNumber", 0);

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListView = (ListView) findViewById(R.id.detail_list);

        mTitles = getResources().getStringArray(R.array.pc_categories_detail_titles);

        CategoriesDetailAdapter listAdapter = new CategoriesDetailAdapter(this, mTitles, mImageId);
        //mListView.setAdapter(listAdapter); // Causes the app to crash
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_categories_detail_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
