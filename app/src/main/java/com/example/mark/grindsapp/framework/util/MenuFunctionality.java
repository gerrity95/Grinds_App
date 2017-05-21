package com.example.mark.grindsapp.framework.util;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.mark.grindsapp.main.UserFiles.Homescreen;
import com.example.mark.grindsapp.main.PreLogin.LoginActivity;

/**
 * Created by Mark on 08/11/2016.
 */

public class MenuFunctionality extends AppCompatActivity {

    public void Home() {
        Intent bringHome = new Intent(getApplicationContext(), Homescreen.class);
        startActivity(bringHome);
    }

    public void Logout()
    {
        Intent logout = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(logout);
    }





}