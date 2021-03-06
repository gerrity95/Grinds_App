package com.example.mark.grindsapp.main.UserFiles.AdditionalFunctions;

import android.app.SearchManager;
import android.content.Context;


import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mark.grindsapp.R;
import com.example.mark.grindsapp.main.UserFiles.Homescreen;
import com.example.mark.grindsapp.main.UserFiles.TutorProfile;

import butterknife.ButterKnife;
import butterknife.InjectView;

/*
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
*/
/**
 * Created by gerrity95 on 16/02/17.
 */

public class UpcomingGrindDetails extends AppCompatActivity {

    private static final int REQUEST_PROFILE = 0;
    //private GoogleMap mMap;

    Homescreen home = new Homescreen();
    TutorSearch tSearch = new TutorSearch();
    LinearLayout tutorProfile;
    Context context;

    @InjectView(R.id.tutor_profile) LinearLayout _tutorProfile;

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

        tutorProfile = (LinearLayout) findViewById(R.id.tutor_profile);
        tSearch.tutorView(context, tutorProfile, "James", "Maths", "Masters", 3, R.drawable.headshot1);


    }



    //Inclusion of map not really realistic, would need changes to do with the memory load just to implement Google Play Services, may look into it in the future but leaving it out for now

      /*
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
*/

    /*
        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            LatLng schoolOfComputing = new LatLng(53.385734, -6.257550);
            mMap.addMarker(new MarkerOptions().position(schoolOfComputing).title("DCU School of Computing"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(schoolOfComputing));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(schoolOfComputing,14));
        }
    */
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

}
