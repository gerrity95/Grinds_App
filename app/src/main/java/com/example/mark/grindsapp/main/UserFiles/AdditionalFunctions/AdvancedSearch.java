package com.example.mark.grindsapp.main.UserFiles.AdditionalFunctions;


import android.icu.text.DateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;


import com.example.mark.grindsapp.R;

import java.lang.reflect.Field;
import java.text.Format;


/**
 * Created by gerrity95 on 08/02/17.
 */
public class AdvancedSearch extends AppCompatActivity {

    DatePicker datePicker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        datePicker = (DatePicker) findViewById(R.id.simpleDatePicker);

        hideYear(datePicker);



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
