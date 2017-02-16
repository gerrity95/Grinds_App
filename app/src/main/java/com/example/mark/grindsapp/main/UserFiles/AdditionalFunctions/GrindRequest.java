package com.example.mark.grindsapp.main.UserFiles.AdditionalFunctions;

import android.os.Bundle;

import com.example.mark.grindsapp.R;
import com.example.mark.grindsapp.main.UserFiles.Homescreen;

/**
 * Created by gerrity95 on 08/02/17.
 */
public class GrindRequest extends Homescreen {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_grind);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
