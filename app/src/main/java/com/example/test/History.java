package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.graphics.Color;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.Toast;
import java.time.LocalDate;


import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class History extends AppCompatActivity {

    CalendarView simpleCalendarView;
    ImageButton btn;
    ImageButton form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.element_bottom_navigation);
        setContentView(R.layout.activity_history);
        addListenerOnButtonClick();
        simpleCalendarView = (CalendarView) findViewById(R.id.calendar); // get the reference of CalendarView

        // perform setOnDateChangeListener event on CalendarView
        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // display the selected date by using a toast
                Toast.makeText(getApplicationContext(), dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
            }
        });

        // Initialize and assign variable
        com.google.android.material.bottomnavigation.BottomNavigationView bottomNavigationView = findViewById(R.id.nav_host_fragment_activity_main);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_history);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navigation_history:
                        return true;
                    case R.id.navigation_checkup:
                        startActivity(new Intent(getApplicationContext(), Check_up.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

    }

    public void addListenerOnButtonClick() {
        btn = (ImageButton)findViewById(R.id.GoBackArrow);
        form = (ImageButton) findViewById(R.id.AddInfo);

        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Autoevaluation.class);
        startActivity(intent);
    }

}

