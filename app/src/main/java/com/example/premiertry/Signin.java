package com.example.premiertry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Signin extends AppCompatActivity {

    private Button buttoncontinuesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        buttoncontinuesi = (Button) findViewById(R.id.buttoncontinuesi);
        buttoncontinuesi.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v){
                openwelcome3();
            }
        });


        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = getSharedPreferences("Mes_Registers", 0);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("user1", "Nana");
        editor.putString("psd1", "pst123");

        editor.putString("user2", "Nesrine");
        editor.putString("psd2", "pst1234");

        editor.putString("user3", "6Rine");
        editor.putString("psd3", "tmoche");

        editor.putString("user4", "Chris");
        editor.putString("psd4", "PSTxRWD");

        editor.commit();
    }

    public void openwelcome3(){
        SharedPreferences settings = getSharedPreferences("Mes_Registers", 0);

        List<String> users = new ArrayList<>();
        users.add(settings.getString("user1", "toto"));
        users.add(settings.getString("user2", "toto"));
        users.add(settings.getString("user3", "toto"));
        users.add(settings.getString("user4", "toto"));

        List<String> passwords = new ArrayList<>();
        passwords.add(settings.getString("psd1", "toto"));
        passwords.add(settings.getString("psd2", "toto"));
        passwords.add(settings.getString("psd3", "toto"));
        passwords.add(settings.getString("psd4", "toto"));

        //get the user from the form
        //users.contains();


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}