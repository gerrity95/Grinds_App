package com.example.mark.grindsapp.main.UserFiles;

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
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.mark.grindsapp.framework.util.MenuFunctionality;
import com.example.mark.grindsapp.main.PreLogin.LoginActivity;
import com.example.mark.grindsapp.R;
import com.example.mark.grindsapp.main.UserFiles.AdditionalFunctions.AdvancedSearch;
import com.example.mark.grindsapp.main.UserFiles.AdditionalFunctions.TutorSearch;
import com.example.mark.grindsapp.main.UserFiles.AdditionalFunctions.UpcomingGrindDetails;

import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mark on 04/10/2016.
 */
public class Homescreen extends AppCompatActivity {

    private static final int REQUEST_ADVANCED_OPTIONS = 0;

    @InjectView(R.id.GrindMoreDetails) TextView _grindDetails;
    @InjectView(R.id.tSearchAdvanced) TextView _advancedOptions;
    @InjectView(R.id.tSearchButton) Button _searchButton;

    CalendarView calendarView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        ButterKnife.inject(this);

        _grindDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Advanced Options activity
                Intent intent = new Intent(getApplicationContext(), UpcomingGrindDetails.class);
                startActivityForResult(intent, REQUEST_ADVANCED_OPTIONS);
            }
        });

        _advancedOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Advanced Options activity
                Intent intent = new Intent(getApplicationContext(), AdvancedSearch.class);
                startActivityForResult(intent, REQUEST_ADVANCED_OPTIONS);
            }
        });

        _searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Advanced Options activity
                Intent intent = new Intent(getApplicationContext(), TutorSearch.class);
                startActivityForResult(intent, REQUEST_ADVANCED_OPTIONS);
            }
        });

        calendarView = (CalendarView) findViewById(R.id.ScheduleCalendar);


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
        Intent i = new Intent(Homescreen.this, Homescreen.class);
        startActivity(i);
    }

    public void Logout()
    {
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
    }

}


