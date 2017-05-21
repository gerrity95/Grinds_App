package com.example.mark.grindsapp.main.UserFiles.AdditionalFunctions;

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
import android.widget.LinearLayout;

import com.example.mark.grindsapp.R;
import com.example.mark.grindsapp.framework.util.MenuFunctionality;
import com.example.mark.grindsapp.main.PreLogin.LoginActivity;
import com.example.mark.grindsapp.main.UserFiles.TutorProfile;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by gerrity95 on 16/02/17.
 */

public class UpcomingGrindDetails extends AppCompatActivity {

    private static final int REQUEST_PROFILE = 0;

    MenuFunctionality menuFunctionality = new MenuFunctionality();
    Context context;

    @InjectView(R.id.tutor_profiler) LinearLayout _tutorProfile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_grind);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = this;

        ButterKnife.inject(this);


        _tutorProfile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Advanced Options activity
                Intent intent = new Intent(getApplicationContext(), TutorProfile.class);
                startActivityForResult(intent, REQUEST_PROFILE);
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
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.home:
                //location found
                menuFunctionality.Home();
                return true;
            case R.id.logout:
                Logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void Logout()
    {
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }

}
