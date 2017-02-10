package com.example.mark.grindsapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mark.grindsapp.main.PreLogin.LoginActivity;
import com.example.mark.grindsapp.main.PreLogin.SignupActivity;
import com.example.mark.grindsapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mark on 29/09/2016.
 */
public class SignupChoice extends AppCompatActivity {
    private static final int REQUEST_SIGNUP = 0;

    @InjectView(R.id.btn_receiveGrinds) Button _receiveButton;
    @InjectView(R.id.btn_giveGrinds) Button _giveButton;
    @InjectView(R.id.link_login) TextView _login;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupchoice);
        ButterKnife.inject(this);

        //on click listeners in here

        _receiveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });

        _giveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });

        _login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });

    }
}
