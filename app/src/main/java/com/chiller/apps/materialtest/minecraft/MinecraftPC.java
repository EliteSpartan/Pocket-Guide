package com.chiller.apps.materialtest.minecraft;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.chiller.apps.materialtest.R;
import com.chiller.apps.materialtest.CategoriesDetailList;
import com.chiller.apps.materialtest.adapters.CategoriesListAdapter;

public class MinecraftPC extends ActionBarActivity {

    ListView mListView;

    // List Items
    String[] mListTitles;
    String[] mListDesc;
    Integer[] mImageId = {

            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minecraft_pc);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // Initializes the Toolbar
        if (toolbar != null) {
            setSupportActionBar(toolbar); // Adds the toolbar if it has not been created
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            // Adds the back button to the Toolbar

        mListView = (ListView) findViewById(R.id.categories_list);

        mListTitles = getResources().getStringArray(R.array.categories_pc_titles);
        mListDesc = getResources().getStringArray(R.array.pc_categories_descriptions);

        CategoriesListAdapter listAdapter = new CategoriesListAdapter(MinecraftPC.this, mListTitles, mListDesc, mImageId);
        mListView.setAdapter(listAdapter);
        mListView.setOnItemClickListener(new ListClickListener());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_minecraft_pc, menu);
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

    private class ListClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            TextView textView = (TextView)view.findViewById(R.id.row_title);
            String title = textView.getText().toString();

            Intent startDetail = new Intent(mListView.getContext(), CategoriesDetailList.class);
            startDetail.putExtra("title", title);
            startDetail.putExtra("itemNumber", position);
            startActivity(startDetail);
        }

    }

}
