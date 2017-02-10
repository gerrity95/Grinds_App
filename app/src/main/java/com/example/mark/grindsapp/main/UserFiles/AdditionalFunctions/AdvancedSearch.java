package com.example.mark.grindsapp.main.UserFiles.AdditionalFunctions;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import com.example.mark.grindsapp.R;

import java.util.Calendar;

/**
 * Created by gerrity95 on 08/02/17.
 */
public class AdvancedSearch extends AppCompatActivity {

    //Button btnDatePicker;
    //EditText dateText;
    //private int day, month, year;

    private TimePicker timePicker1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);

        timePicker1.setIs24HourView(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            timePicker1.setMinute(0);
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
