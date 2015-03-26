package com.chiller.apps.materialtest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.chiller.apps.materialtest.Adapter.DrawerList;
import com.chiller.apps.materialtest.minecraft.MinecraftPC;
import com.chiller.apps.materialtest.minecraft.MinecraftPE;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

public class MainActivity extends ActionBarActivity {

    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;

    CharSequence mTitle;
    String[] mDrawerTitles;
    Integer[] imageId = {

            R.drawable.ic_gamepad_grey600_24dp,
            R.drawable.ic_favorite_grey600_24dp
    };

    ListView mDrawerList;
    RelativeLayout mDrawerRelative;
    FrameLayout mContent;
    Context context;
    SharedPreferences onFirstRun = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onFirstRun = getSharedPreferences("com.chiller.test", MODE_PRIVATE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        mTitle = getSupportActionBar().getTitle(); // Gets the Title of the Toolbar
        mDrawerTitles = getResources().getStringArray(R.array.drawer_titles_top);// Gets the Drawer Titles

        // Initializes the Navigation Drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerRelative = (RelativeLayout) findViewById(R.id.drawer);
        mContent = (FrameLayout) findViewById(R.id.content_frame);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerList = (ListView) findViewById(R.id.list_top);

        // Adds the Items to the List
        DrawerList drawerAdapter = new DrawerList(MainActivity.this, mDrawerTitles, imageId);

        View drawerHeader = getLayoutInflater().inflate(R.layout.drawer_header, null);
        View drawerFooter = getLayoutInflater().inflate(R.layout.drawer_footer, null);
        mDrawerList.addHeaderView(drawerHeader, null, false); // Adds the Drawer Header
        mDrawerList.addFooterView(drawerFooter, null, false); // Adds the Drawer Footer

        // Initializes the Drawer List
        mDrawerList.setAdapter(drawerAdapter);
        context = getApplicationContext();
        mDrawerList.setOnItemClickListener(new DrawerClickListener());
        mDrawerList.setSelector(R.drawable.drawer_item_click);

        if (savedInstanceState == null) {
            displayView(0);
        }

        //new RequestTask().execute("http://pure.chiller.x10.mx/data/Minecraft-Blocks.json");
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (onFirstRun.getBoolean("onFirstRun", true)) {

            new MaterialDialog.Builder(this)
                    .title("EULA")
                    .cancelable(false)
                    .content("Please accept all of these Terms and Conditions.")
                    .positiveText("Agree")
                    .positiveColorRes(R.color.colorPrimary)
                    .negativeText("Disagree")
                    .callback( new MaterialDialog.ButtonCallback() {

                        @Override
                        public void onPositive(MaterialDialog dialog) {
                            super.onPositive(dialog);
                            onFirstRun.edit().putBoolean("onFirstRun", false).apply();
                        }

                        @Override
                        public void onNegative(MaterialDialog dialog) {
                            super.onNegative(dialog);
                            onFirstRun.edit().putBoolean("onFirstRun", true).apply();
                            moveTaskToBack(true);
                        }

                    })
                    .show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_search:
                SnackbarManager.show(
                    Snackbar.with(getApplicationContext())
                            .text("Search is currently not available.")
                            .swipeToDismiss(false), this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {

        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
            mDrawerLayout.closeDrawer(mDrawerRelative);
            return;
        }

        super.onBackPressed();
    }

    // When Drawer Settings is clicked
    public void launchSettings (View view) {

        SnackbarManager.show(
                Snackbar.with(getApplicationContext())
                .text("There are no settings currently.")
                .swipeToDismiss(false),
                this
        );

    }

    // When Drawer Help is Clicked
    public void launchHelp(View view) {

        // Make a Snackbar
        /**Snackbar.with(getApplicationContext()) // context
                .text("Help is currently not available.") // text to display
                .show(this); // activity where it is displayed**/

        Intent startHelp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://pure.chiller.x10.mx/apps/help"));
            // Not Final Page
        startActivity(startHelp);

    }

    // When Drawer Feedback is Clicked
    public void launchFeedback(View view) {

        Intent startFeedback = new Intent(Intent.ACTION_VIEW, Uri.parse("http://pure.chiller.x10.mx/apps/help"));
            // Not Final Page
        startActivity(startFeedback);
    }

    // Launches PC Activity
    public void launchPC(View view) {

        Intent startPC = new Intent(this, MinecraftPC.class);
        startActivity(startPC);
    }

    public void launchPE(View view) {

        Intent startPE = new Intent(this, MinecraftPE.class);
        startActivity(startPE);
    }

    // The Drawer Click Listener (Changes Fragments)
    private class DrawerClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            displayView(position - mDrawerList.getHeaderViewsCount());
        }
    }

    private void displayView(int position) {

        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = null;

        switch (position) {

            case 0:
                fragment = new GamesFragment();
                break;
            case 1:
                fragment = new PinnedFragment();
                break;

            default:
                break;
        }

        if (fragment != null) {

            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mDrawerTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerRelative);
        }

        else {

            Log.e("MainActivity", "Error in Creating Fragment");
        }
    }

    @Override
    public void setTitle(CharSequence title) {

        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }


}