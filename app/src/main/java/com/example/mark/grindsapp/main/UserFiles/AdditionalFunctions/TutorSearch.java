package com.example.mark.grindsapp.main.UserFiles.AdditionalFunctions;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mark.grindsapp.R;
import com.example.mark.grindsapp.framework.util.MenuFunctionality;
import com.example.mark.grindsapp.main.UserFiles.Homescreen;

/**
 * Created by gerrity95 on 08/02/17.
 */
public class TutorSearch extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

}