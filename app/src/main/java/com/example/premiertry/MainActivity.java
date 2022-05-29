package com.example.premiertry;

import static com.example.premiertry.CalendarUtils.daysInMonthArray;
import static com.example.premiertry.CalendarUtils.monthYearFromDate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import com.example.premiertry.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ImageButton checkup_button;
    private ImageButton portfoliobutton;
    private ImageButton profilpicface;


    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        checkup_button = (ImageButton)findViewById(R.id.checkup_button);
        checkup_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openCheck_up();
            }
        });

        portfoliobutton = (ImageButton)findViewById(R.id.imageButton4);
        portfoliobutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPortfolio();
            }
        });

        profilpicface = (ImageButton) findViewById(R.id.imageButton5);
        profilpicface.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openProfil();
            }
        });


    }

    public void checkupAction(View view)
    {
        startActivity(new Intent(this, WeekViewActivity.class));
    }
    public void openCheck_up(){
        Intent intent = new Intent(this, CheckUpActivity.class);
        startActivity(intent);
    }
    public void openPortfolio(){
        Intent intent = new Intent(this, PortfolioActivity.class);
        startActivity(intent);
    }
    public void openProfil(){
        Intent intent = new Intent(this, ProfilActivity.class);
        startActivity(intent);
    }
}