package com.example.elifozcevik.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class Home extends AppCompatActivity {
    private ActionMode mActionMode;
    DrawerLayout mDrawerLayout;
    String mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_list);
        mDrawerLayout = findViewById(R.id.drawer_layout);

        Intent myIntent=getIntent();
        mail=(myIntent.getStringExtra("mail"));
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        if (id == R.id.nav_workouts) {
                            Intent registerIntent=new Intent(Home.this,Workouts.class);
                            startActivity(registerIntent);

                        } else if (id == R.id.nav_home) {
                            Intent registerIntent=new Intent(Home.this,HomePage.class);
                            registerIntent.putExtra("mail", mail);
                            startActivityForResult(registerIntent,300);
                        }
                        else if (id == R.id.nav_news) {
                            Intent intent=new Intent(Home.this,BMI.class);
                            startActivity(intent);


                        } else if (id == R.id.nav_contact) {
                            Intent intent=new Intent(Home.this,Contact.class);
                            startActivity(intent);

                        }
                        else if(id==R.id.nav_trainer){
                            Intent intent=new Intent(Home.this,Trainers.class);
                            startActivity(intent);
                        }
                        else System.exit(0);

                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });

    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:

                return true;
            case R.id.action_add:

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public ActionMode.Callback mActionModeCallback =
            new ActionMode.Callback() {

                @Override
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    MenuInflater inflater = mode.getMenuInflater();
                    inflater.inflate(R.menu.nev_menu, menu);
                    return true;
                }

                @Override
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false; // Return false if nothing is done.
                }

                @Override
                public void onDestroyActionMode(ActionMode mode) {
                    mActionMode = null;
                }

                @Override
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_workouts:

                            return true;
                        default:
                            return false;
                    }
                }

            };

*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if(mDrawerLayout.isDrawerOpen(Gravity.START)==false)
                    mDrawerLayout.openDrawer(Gravity.START);
                else
                    mDrawerLayout.closeDrawer(Gravity.START);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
