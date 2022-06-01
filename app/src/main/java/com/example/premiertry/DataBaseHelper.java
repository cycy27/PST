package com.example.premiertry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String USER_TABLE = "user";
    public static final String COLUMN_USER_ID = "USER_ID";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_NAME = "NAME";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "cardiobend.db", null, 1);
    }


    //created the first time database is used
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "CREATE TABLE " + USER_TABLE + " (" + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " VARCHAR(25)," +
                COLUMN_EMAIL + " VARCHAR(25), " + COLUMN_PASSWORD + " VARCHAR(25))";
        db.execSQL(createTableStatement);



    }

    //called whenever we make changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addOne (User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();

        cv.put(COLUMN_NAME,user.getName());
        cv.put(COLUMN_EMAIL,user.getEmail());
        cv.put(COLUMN_PASSWORD,user.getPassword());

        long insert = db.insert(USER_TABLE, null, cv);
        if(insert==-1){
            return false;
        }

        return true;
    }

    public List<User> getAllUsers(){
        SQLiteDatabase db = this.getReadableDatabase();

        List<User> allUsers= new ArrayList<>();
        String queryString ="SELECT * FROM "+USER_TABLE;

        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            //loop through the cursor( result set) and create a new user object
            //put them in the return list
            do {

                User user= new User (cursor.getInt(0),cursor.getString(1),
                        cursor.getString(2),cursor.getString(3));
                allUsers.add(user);


            } while(cursor.moveToNext());

        }
        else{
            //failure. do not add anything to the list

        }
        cursor.close();
        db.close();
        return allUsers;
    }

    public boolean checkUser(String userEmail, String userPassword){
        SQLiteDatabase db = this.getReadableDatabase();
        User user=null;
        String queryString ="SELECT  * FROM " + USER_TABLE + " WHERE "+COLUMN_EMAIL+"=\'"
                + userEmail+"\'" +" AND "+COLUMN_PASSWORD+"=\'"+userPassword+"\'";
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            cursor.close();
            db.close();
            return true;

        }
        cursor.close();
        db.close();
        return false;
    }

    public boolean checkUser(String userEmail){
        SQLiteDatabase db = this.getReadableDatabase();
        User user=null;
        String queryString ="SELECT  * FROM " + USER_TABLE + " WHERE "+COLUMN_EMAIL+"=\'"
                + userEmail+"\'";
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            cursor.close();
            db.close();
            return true;

        }
        cursor.close();
        db.close();
        return false;
    }
}