package com.example.mpd_coursework;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private Button startButton;
    private ProgressBar progressBar;
    private TextView txt_percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MyTag", "In on Create");

        startButton = findViewById(R.id.btn_start);
        progressBar = findViewById(R.id.progress);
        txt_percentage= findViewById(R.id.txt_percentage);
        startButton.setOnClickListener(this);


        nvDrawer = findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);
        //Set a toolbar to replace the actionbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawer = findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();
        mDrawer.addDrawerListener(drawerToggle);
        Log.e("MyTag", "After start button");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    private void setupDrawerContent(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener()
                {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem)
    {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.eqSearch:
                fragmentClass = SearchFragment.class;
                break;
            case R.id.eqMap:
                fragmentClass = MapsFragment.class;
                break;
            default:
                fragmentClass = HomeFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onClick(View v)
    {
        if (v == startButton)
        {
            startButton.setEnabled(false);
            progressBar.setVisibility(View.VISIBLE);
            new ShowDialogAsyncTask().execute();
        }
    }


    private class ShowDialogAsyncTask extends AsyncTask<Void, Integer, Void>
    {

        int progress_status;

        @Override
        protected void onPreExecute()
        {
            // update the UI immediately after the task is executed
            super.onPreExecute();

            progress_status = 0;
            txt_percentage.setText("Press Start to Download Earthquake Data.");

        }

        @Override
        protected Void doInBackground(Void... params)
        {

            while(progress_status<100)
            {

                progress_status += 2;

                publishProgress(progress_status);
                // Sleep but normally do something useful here such as access a web resource
                SystemClock.sleep(300); // or Thread.sleep(300);


            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0]);

            txt_percentage.setText("Downloading Earthquake Data. Please Wait " +values[0] + "%");
            startButton.setVisibility(View.INVISIBLE);
        }

        @Override
        protected void onPostExecute(Void result)
        {
            super.onPostExecute(result);

            Toast.makeText(MainActivity.this,
                    "All Data Downloaded", Toast.LENGTH_SHORT).show();

            txt_percentage.setText("Download complete");
            startButton.setEnabled(true);
            progressBar.setVisibility(View.INVISIBLE);
            startButton.setVisibility(View.INVISIBLE);
            txt_percentage.setVisibility(View.INVISIBLE);

            HomeFragment hf = new HomeFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.flContent, hf).commit();

        }

    } // End of AsyncTask
}