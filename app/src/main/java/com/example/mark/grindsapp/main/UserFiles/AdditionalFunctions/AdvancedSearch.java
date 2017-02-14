package com.example.mark.grindsapp.main.UserFiles.AdditionalFunctions;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;


import com.example.mark.grindsapp.R;
import com.example.mark.grindsapp.main.UserFiles.Homescreen;

import java.lang.reflect.Field;
import java.text.Format;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by gerrity95 on 08/02/17.
 */
public class AdvancedSearch extends AppCompatActivity {

    private static final int REQUEST_TUTOR_SEARCH = 0;

    @InjectView(R.id.advanced_submit) Button _requestTutor;

    DatePicker datePicker;

    Homescreen home = new Homescreen();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        datePicker = (DatePicker) findViewById(R.id.simpleDatePicker);

        hideYear(datePicker);

        ButterKnife.inject(this);

        _requestTutor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), TutorSearch.class);
                startActivityForResult(intent, REQUEST_TUTOR_SEARCH);
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


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                //location found
                home.Home();
                return true;
            case R.id.logout:
                home.Logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void hideYear(DatePicker dt)
    {
        try {
            Field f[] = dt.getClass().getDeclaredFields();
            for (Field field : f) {
                 if (field.getName().equals("mYearPicker") || field.getName().equals("mYearSpinner")) {
                     field.setAccessible(true);
                     Object yearPicker = new Object();
                     yearPicker = field.get(dt);
                     ((View) yearPicker).setVisibility(View.GONE);
                 }

            }
        } catch (SecurityException e) {
            Log.d("ERROR", e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
