package com.example.test;

import android.graphics.Color;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class Autoevaluation extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoevaluation);

        // By ID get the AutoCompleteTextView
        // which id is assign in xml file
        AutoCompleteTextView
                autoCompleteTextView
                = (AutoCompleteTextView)
                findViewById(
                        R.id.autocompleteTextView);

        // Create the string array
        // and store the values.
        String[] symptoms
                = { "Took medication", "Allergic reaction in last 5 hours", "High Blood Pressure",
                "Low Blood pressure", "Low Sugar level", "High Sugar level",
                "nose bleeding", "Diarrhea", "Constipation" };

        // Create the object of ArrayAdapter with String
        // which hold the data as the list item.
        ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(
                this,
                android.R.layout.select_dialog_item,
                symptoms);

        // Give the suggestion after 1 words.
        autoCompleteTextView.setThreshold(1);

        // Set the adapter for data as a list
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setTextColor(Color.BLACK);


        BottomNavigationView navView = findViewById(R.id.nav_host_fragment_activity_main);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_checkup, R.id.navigation_history)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
}