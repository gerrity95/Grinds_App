package com.example.mark.grindsapp.main.PreLogin;

/**
 * Created by Mark on 28/09/2016.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.mark.grindsapp.R;
import com.example.mark.grindsapp.framework.util.LoginDataBaseAdapter;
import com.example.mark.grindsapp.main.UserFiles.Homescreen;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";
    private static final int REQUEST_SIGNUP = 0;

    TextInputEditText editTextName, editTextEmail, editTextPassword;

    CharSequence errorMessage = "Registration Failed";

    LoginDataBaseAdapter loginDataBaseAdapter;


    @InjectView(R.id.input_name) TextInputEditText _nameText;
    @InjectView(R.id.input_email) TextInputEditText _emailText;
    @InjectView(R.id.input_password) TextInputEditText _passwordText;
    @InjectView(R.id.btn_signup) Button _signupButton;
    @InjectView(R.id.link_login) TextView _loginLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.inject(this);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
    }

    public void signup() {

        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed(errorMessage);
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement your own signup logic here.
        //This is where the database code would be put


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);

        Intent intent = new Intent(getApplicationContext(), Homescreen.class);
        startActivityForResult(intent, REQUEST_SIGNUP);

    }


    public void onSignupSuccess() { //This is where we state what happens if it is a success - move to new activity
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed(CharSequence t) {
        Toast.makeText(getBaseContext(), t, Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
/*
        if(radioValue == -1)
        {
            errorMessage = "Must select a user type!";
            valid = false;
        }
*/
        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
            errorMessage = "Invalid username!";

        } else {
            _nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
            errorMessage = "Invalid Email!";
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
            errorMessage = "Invalid Password!";
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }


}
