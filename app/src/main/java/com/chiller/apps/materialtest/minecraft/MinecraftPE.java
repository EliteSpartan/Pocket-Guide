package com.chiller.apps.materialtest.minecraft;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.chiller.apps.materialtest.R;

public class MinecraftPE extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minecraft_pe);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // Initializes the Toolbar
        if (toolbar != null) {
            setSupportActionBar(toolbar); // Adds the toolbar if it has not been created
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            // Adds the back button to the Toolbar
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_minecraft_pe, menu);
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
