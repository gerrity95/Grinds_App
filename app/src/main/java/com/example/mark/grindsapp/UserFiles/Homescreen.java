package com.example.mark.grindsapp.UserFiles;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.mark.grindsapp.PreLogin.LoginActivity;
import com.example.mark.grindsapp.R;

/**
 * Created by Mark on 04/10/2016.
 */
public class Homescreen extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.action_search:
                //search action
                return true;
            case R.id.home:
                //location found
                Home();
                return true;
            case R.id.schedule:
                //reset found
                return true;
            case R.id.about:
                //about action
                return true;
            case R.id.logout:
                Logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    private void Home() {
        Intent i = new Intent(Homescreen.this, Homescreen.class);
        startActivity(i);
    }

    private void Logout()
    {
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
    }

}


