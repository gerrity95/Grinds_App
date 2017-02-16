package com.example.mark.grindsapp.main.UserFiles.AdditionalFunctions;

import android.app.ActionBar;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.Rating;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.mark.grindsapp.R;
import com.example.mark.grindsapp.framework.util.MenuFunctionality;
import com.example.mark.grindsapp.main.UserFiles.Homescreen;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by gerrity95 on 08/02/17.
 */
public class TutorSearch extends AppCompatActivity {

    private static final int REQUEST_ADVANCED_OPTIONS = 0;

    LinearLayout tutorLink;

    @InjectView(R.id.advanced_options_link) TextView _advancedSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.inject(this);

        _advancedSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Advanced Options activity
                Intent intent = new Intent(getApplicationContext(), AdvancedSearch.class);
                startActivityForResult(intent, REQUEST_ADVANCED_OPTIONS);
            }
        });

        tutorLink = (LinearLayout) findViewById(R.id.testlayout);
        tutorView(tutorLink, "James", "Maths", "Masters", 3, R.drawable.headshot1);
        tutorView(tutorLink, "Mark", "English", "Undergraduate", 2, R.drawable.headshot2);
        tutorView(tutorLink, "Sarah", "History", "Arts Degree", 5, R.drawable.headshot3);

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

    private void tutorView(LinearLayout lt, String name, String subject, String qualifications, int rating, int photoUrl)
    {
        LinearLayout primary = new LinearLayout(this);
        primary.setOrientation(LinearLayout.HORIZONTAL);
        primary.setWeightSum(2);
        primary.setPadding(0, 10, 0, 10);
        primary.setBackgroundResource(R.drawable.home_bottom_border);

        LinearLayout.LayoutParams secondaryParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams ratingBarDetails = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        secondaryParams.weight = 1;

        LinearLayout secondary = new LinearLayout(this);
        secondary.setOrientation(LinearLayout.VERTICAL);
        secondary.setLayoutParams(secondaryParams);
        secondary.setPadding(5, 0, 0, 0);

        ImageView tutorPhoto = new ImageView(this);
        tutorPhoto.setLayoutParams(secondaryParams);
        tutorPhoto.setPadding(15, 15, 15, 15);
        tutorPhoto.setImageResource(photoUrl);


        TextView nameView = new TextView(this);
        textViewDetails(nameView, "Name: " + name, 10);

        TextView subjectView = new TextView(this);
        textViewDetails(subjectView, "Subjects: " + subject, 10);

        TextView qualView = new TextView(this);
        textViewDetails(qualView, "Qualifications: " + qualifications, 10);

        RatingBar ratingBar = new RatingBar(this, null, android.R.attr.ratingBarStyleSmall);
        ratingBar.setNumStars(5);
        ratingBar.setRating(rating);
        ratingBar.setPadding(10, 10, 10, 10);
        ratingBar.setLayoutParams(ratingBarDetails);

        TextView moreDetails = new TextView(this);
        textViewDetails(moreDetails, "View Profile... ", 10);
        moreDetails.setTextColor(Color.parseColor("#0645AD"));

        secondary.addView(nameView);
        secondary.addView(subjectView);
        secondary.addView(qualView);
        secondary.addView(ratingBar);
        secondary.addView(moreDetails);


        primary.addView(secondary);
        primary.addView(tutorPhoto);
        lt.addView(primary);
    }

    public void textViewDetails(TextView t, String name, int padding)
    {
        t.setText(name);
        t.setPadding(padding, padding, padding, padding);

        LinearLayout.LayoutParams textviewParams = new LinearLayout.LayoutParams(0, 100);
        textviewParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        textviewParams.width = ViewGroup.LayoutParams.MATCH_PARENT;

        t.setLayoutParams(textviewParams);


    }


}