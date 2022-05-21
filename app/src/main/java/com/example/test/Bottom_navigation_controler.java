package com.example.test;

import java.io.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import com.example.Fragment.*;
import com.example.test.ui.checkup.CheckupFragment;
import com.example.test.ui.history.HistoryFragment;
import com.example.test.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;


public class Bottom_navigation_controler extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.element_bottom_navigation);

        bottomNavigationView = findViewById(R.id.nav_host_fragment_activity_main);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

    }
    HomeFragment homeFragment = new HomeFragment();
    CheckupFragment checkupFragment = new CheckupFragment();
    HistoryFragment historyFragment = new HistoryFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navigation_checkup:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, checkupFragment).commit();
                return true;

            case R.id.navigation_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                return true;

            case R.id.navigation_history:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, historyFragment).commit();
                return true;
        }
        return false;
    }
}


