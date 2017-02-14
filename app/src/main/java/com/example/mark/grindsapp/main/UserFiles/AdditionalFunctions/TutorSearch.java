package com.example.mark.grindsapp.main.UserFiles.AdditionalFunctions;

import android.app.ActionBar;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
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

    RatingBar ratingBar;
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

        ratingBar = (RatingBar) findViewById(R.id.first_ratingBar);
        ratingBar.setNumStars(5);
        ratingBar.setRating(4);

        tutorLink = (LinearLayout) findViewById(R.id.testlayout);
        tutorView(tutorLink, "James", "Maths", "Masters", 3, R.drawable.headshot1);

        /*
        LinearLayout firstTutor = new LinearLayout(this);
        firstTutor.setOrientation(LinearLayout.HORIZONTAL);

        TextView textView = new TextView(this);
        textView.setText("Hello");

        firstTutor.addView(textView);
        tutorLink.addView(firstTutor);
        */
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

    private void tutorView(LinearLayout lt, String name, String Subject, String qualifications, int rating, int photoUrl)
    {
        LinearLayout primary = new LinearLayout(this);
        primary.setOrientation(LinearLayout.HORIZONTAL);
        primary.setWeightSum(2);

        LinearLayout.LayoutParams secondaryParams = new LinearLayout.LayoutParams(0, 100);
        secondaryParams.weight = 1;
        secondaryParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        secondaryParams.width = ViewGroup.LayoutParams.MATCH_PARENT;

        LinearLayout secondary = new LinearLayout(this);
        secondary.setOrientation(LinearLayout.VERTICAL);
        secondary.setLayoutParams(secondaryParams);



        ImageView tutorPhoto = new ImageView(this);
        tutorPhoto.setLayoutParams(secondaryParams);
        tutorPhoto.setPadding(15, 15, 15, 15);

        tutorPhoto.setImageResource(photoUrl);

        TextView nameView = new TextView(this);
        nameView.setText("Name: " + name);
        nameView.setPadding(5, 5, 5, 5);

        TextView subjectView = new TextView(this);
        subjectView.setText("Subject: " + Subject);
        subjectView.setPadding(5, 5, 5, 5);

        TextView qualView = new TextView(this);
        qualView.setText("Qualifications: " + qualifications);
        qualView.setPadding(5, 5, 5, 5);

        RatingBar ratingBar = new RatingBar(this, null, android.R.attr.ratingBarStyleSmall);
        ratingBar.setNumStars(5);
        ratingBar.setRating(rating);
        ratingBar.setPadding(5, 5, 5, 5);

        TextView moreDetails = new TextView(this);
        moreDetails.setText("View Profile...");
        moreDetails.setPadding(5, 5, 5, 5);


        secondary.addView(nameView);
        secondary.addView(subjectView);
        secondary.addView(qualView);
        secondary.addView(ratingBar);
        secondary.addView(moreDetails);



        primary.addView(secondary);
        primary.addView(tutorPhoto);
        lt.addView(primary);
    }


}