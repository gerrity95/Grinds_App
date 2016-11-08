package com.example.mark.grindsapp.framework.util;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.mark.grindsapp.main.Homescreen;
import com.example.mark.grindsapp.main.LoginActivity;

/**
 * Created by Mark on 08/11/2016.
 */

public class MenuFunctionality extends AppCompatActivity {

    public void Home() {
        Intent i = new Intent(this, Homescreen.class);
        startActivity(i);
    }

    public void Logout()
    {
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }


}
