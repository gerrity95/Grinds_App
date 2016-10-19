package com.example.mark.grindsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Mark on 04/10/2016.
 */
public class LoginDataBaseAdapter {

    static final String DATABASE_NAME = "androidTest.sqlite";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    public static final String TABLE_NAME = "users";

    // SQL Statement to create a new database.
    static final String DATABASE_CREATE = "create table "+TABLE_NAME+
            "(ID integer primary key autoincrement,"+ "username  text, email text, password text);";
    // Variable to hold the database instance

    //variable to hold DB instance
    public SQLiteDatabase db;

    //Context of the application using the database
    private final Context context;

    private DataBaseHelper dbHelper;

    public LoginDataBaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public LoginDataBaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insertEntry(String username, String email, String password)
    {
        ContentValues newValues = new ContentValues();
        //Assign values for each row
        newValues.put("username", username);
        newValues.put("email", email);
        newValues.put("password", password);

        //Insert the row into the table
        db.insert("users", null, newValues);
        //Toast.makeText(context, "Reminder is successfully Saved", Toast.LENGTH_LONG).show();
    }

    public int deleteEntry(String Username)
    {
        //String id = String.valueOf(ID);
        String where="username=?";
        int numberOfEntriesDeleted= db.delete("users", where, new String[]{Username});
        // Toast.makeText(context, "Number of Entries deleted successfully : " +numberOfEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOfEntriesDeleted;
    }

    public String getSingleEntry(String username)
    {
        Cursor cursor = db.query("users", null, " username=?", new String[]{username}, null, null, null);
        if(cursor.getCount() < 1)
        {
            cursor.close();
            return "NOT EXIST";
        }

        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("password"));
        cursor.close();
        return password;
    }

    public void updateEntry(String username, String email, String password)
    {
        //Define the updated row content
        ContentValues updatedValues = new ContentValues();
        //Assing values for each row
        updatedValues.put("username", username);
        updatedValues.put("email", email);
        updatedValues.put("password", password);

        String where="username=?";
        db.update("users", updatedValues, where, new String[]{username});
    }
}
