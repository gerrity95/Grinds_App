package com.example.mark.grindsapp.main;

import com.example.mark.grindsapp.R;
import com.example.mark.grindsapp.framework.util.*;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mark on 04/10/2016.
 */
public class Homescreen extends AppCompatActivity {

    public static final int new_Activity = 0;

    @InjectView(R.id.imageButton_search) ImageButton searchTutors;
    @InjectView(R.id.imageButton_messages) ImageButton viewMessages;
    @InjectView(R.id.imageButton_schedule) ImageButton viewSchedule;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        ButterKnife.inject(this);

        searchTutors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the TutorList activity
                Intent intent = new Intent(getApplicationContext(), TutorList.class);
                startActivityForResult(intent, new_Activity);
            }
        });

        viewMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Message activity
                Intent intent = new Intent(getApplicationContext(), Messages.class);
                startActivityForResult(intent, new_Activity);
            }
        });

        viewSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Schedule activity
                Intent intent = new Intent(getApplicationContext(), Schedule.class);
                startActivityForResult(intent, new_Activity);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.taskbar_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.action_search:
                //search action
                return true;
            case R.id.home:
                //location found
                Home();
                return true;
            case R.id.schedule:
                //reset found
                return true;
            case R.id.about:
                //about action
                return true;
            case R.id.logout:
                Logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void Home() {

        Intent intent = new Intent(Homescreen.this, Homescreen.class);
        startActivity(intent);
    }

    public void Logout()
    {
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }


}


