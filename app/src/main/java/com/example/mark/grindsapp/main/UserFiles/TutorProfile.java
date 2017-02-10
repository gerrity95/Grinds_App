package com.example.mark.grindsapp.main.UserFiles;

import android.os.Bundle;

import com.example.mark.grindsapp.R;

/**
 * Created by gerrity95 on 08/02/17.
 */
public class TutorProfile extends Homescreen {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
