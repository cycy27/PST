package com.example.premiertry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import android.view.View;


public class PortfolioActivity extends AppCompatActivity {
    private ImageButton bouttonhelp;
    private ImageButton goback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);
        bouttonhelp = (ImageButton) findViewById(R.id.hlpbtn);
        bouttonhelp.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                openHelp();
            }
        });

        goback = (ImageButton) findViewById(R.id.imageButton10);
        goback.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                openMainActivity();
            }
        });
    }
    public void openHelp(){
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}