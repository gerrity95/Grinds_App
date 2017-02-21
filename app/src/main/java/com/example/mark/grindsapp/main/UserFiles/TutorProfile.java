package com.example.mark.grindsapp.main.UserFiles;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.mark.grindsapp.R;
import com.example.mark.grindsapp.main.UserFiles.AdditionalFunctions.TutorSearch;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by gerrity95 on 08/02/17.
 */
public class TutorProfile extends AppCompatActivity {

    Homescreen home = new Homescreen();
    RatingBar r;

    Context context;

    @InjectView(R.id.request_button) Button _requestButton;
    CharSequence submittedRequest = "Request Submitted!";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = this;

        ButterKnife.inject(this);

        _requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), submittedRequest, Toast.LENGTH_LONG).show();
            }
        });

        r = (RatingBar) findViewById(R.id.tutor_rating);

        r.setNumStars(5);
        r.setRating(3);

        /* I was going to incorporate the top of the tutor programmatically (pic and short details) from tutor_search but thought the layout was different enough that I
        rather putting it into the XML code
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