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

    public static final String USER_INFO_TABLE = "user_info";
    public static final String USER_TABLE = "user";
    public static final String CHECK_UP_TABLE = "check_up";
    public static final String EVALUATION_TABLE = "evaluation";
    public static final String FAMILY_TABLE = "family";




    public static final String COLUMN_USER_ID = "USER_ID";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_NAME = "NAME";

    public static final String COLUMN_PHONE_NUMBER = "PHONE_NUMBER";
    public static final String COLUMN_AGE = "AGE";
    public static final String COLUMN_SEX = "SEX";

    public static final String COLUMN_DATE = "DATE_TIME";
    public static final String COLUMN_BLOOD_PRESSURE = "BLOOD_PRESSURE";
    public static final String COLUMN_HEART_RATE = "HEART_RATE";
    public static final String COLUMN_TEMPERATURE = "TEMPERATURE";
    public static final String COLUMN_SPO2 = "SPO2";

    public static final String COLUMN_PAIN_LEVEL ="PAIN_LEVEL";
    public static final String COLUMN_HEAD_ACHE ="HEAD_ACHE";
    public static final String COLUMN_OUT_OF_BREATH ="UT_OF_BREATH";
    public static final String COLUMN_STIFF ="STIFF ";
    public static final String COLUMN_CHEST_PAIN ="CHEST_PAIN ";
    public static final String COLUMN_FAINT ="FAINT";
    public static final String COLUMN_COUGH ="COUGH";
    public static final String COLUMN_OTHER="OTHER";

    public static final String COLUMN_FAMILY_USER_ID="FAMILY_USER_ID";




    public DataBaseHelper(@Nullable Context context) {
        super(context, "cardiobend.db", null, 1);
    }


    //created the first time database is used
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable= "CREATE TABLE " + USER_TABLE + " (" + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " VARCHAR(25) not null," +
                COLUMN_EMAIL + " VARCHAR(25) not null, " + COLUMN_PASSWORD + " VARCHAR(25)not null)";

        String createCheckupTable= "CREATE TABLE " + CHECK_UP_TABLE + " (" + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DATE + " VARCHAR(25)," +
                COLUMN_BLOOD_PRESSURE + " INTEGER, " +
                COLUMN_HEART_RATE + " INTEGER, " +
                COLUMN_TEMPERATURE + " INTEGER, "
                + COLUMN_SPO2 + " INTEGER)";

        String createEvaluationTable= "CREATE TABLE " + EVALUATION_TABLE + " ("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_DATE + " VARCHAR(25)," +
                COLUMN_PAIN_LEVEL + " INTEGER, " +
                COLUMN_HEAD_ACHE + " CHAR(1), " +
                COLUMN_OUT_OF_BREATH + " CHAR(1), " +
                COLUMN_STIFF + " CHAR(1), " +
                COLUMN_CHEST_PAIN + " CHAR(1), " +
                COLUMN_FAINT + " CHAR(1), "+
                COLUMN_COUGH + " CHAR(1), "
                + COLUMN_OTHER + " VARCHAR(50))";

        String createFamilyTable= "CREATE TABLE " + FAMILY_TABLE + " (" + COLUMN_FAMILY_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " VARCHAR(25) not null," +
                COLUMN_PHONE_NUMBER + " INTEGER not null, "+
                COLUMN_USER_ID + " VARCHAR(25) not null, "
                + " FOREIGN KEY ("+COLUMN_USER_ID+") REFERENCES "+USER_TABLE+"("+COLUMN_USER_ID+"))";



        db.execSQL(createCheckupTable);
        db.execSQL(createUserTable);
        db.execSQL(createEvaluationTable);
        db.execSQL(createFamilyTable);








    }

    //called whenever we make changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            String createFamilyTable= "CREATE TABLE " + FAMILY_TABLE + " (" + COLUMN_FAMILY_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " VARCHAR(25) not null," +
                    COLUMN_PHONE_NUMBER + " INTEGER not null, "+
                    COLUMN_USER_ID + " VARCHAR(25) not null, "
                    + " FOREIGN KEY ("+COLUMN_USER_ID+") REFERENCES "+USER_TABLE+"("+COLUMN_USER_ID+"))";
            //db.execSQL(createFamilyTable);
            String alterTable= "ALTER TABLE " +EVALUATION_TABLE+
                    " ADD "+COLUMN_OTHER +" VARCHAR(50); ";
            db.execSQL(alterTable);

        }
    }
    public boolean addOneUser (User user){
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

    public boolean addEvaluation (TodayEvaluation eval){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        //change Y N to 1 0
        cv.put(COLUMN_DATE,eval.getDateTime());
        cv.put(COLUMN_PAIN_LEVEL,eval.getPainLevel());
        cv.put(COLUMN_HEAD_ACHE,eval.isHeadAche()?"Y":"N");
        cv.put(COLUMN_OUT_OF_BREATH,eval.isOutOfBreath()?"Y":"N");
        cv.put(COLUMN_STIFF,eval.isStiff()?"Y":"N");
        cv.put(COLUMN_CHEST_PAIN,eval.isFaint()?"Y":"N");
        cv.put(COLUMN_FAINT,eval.isFaint()?"Y":"N");
        cv.put(COLUMN_COUGH,eval.isCough()?"Y":"N");
        cv.put(COLUMN_OTHER,eval.getOther());

        long insert = db.insert(EVALUATION_TABLE, null, cv);
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

