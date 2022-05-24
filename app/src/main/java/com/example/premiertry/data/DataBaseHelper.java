package com.example.premiertry.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String USER = "user";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "cardiobend.db", null, 1);
    }


    //created the first time database is used
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "CREATE TABLE " + USER + " (USER_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EMAIL VARCHAR(50), )";
        db.execSQL(createTableStatement);

    }

    //called whenever we make changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
