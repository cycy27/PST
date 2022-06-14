package com.example.premiertry;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageButton;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    private ImageButton checkup_button;
    private ImageButton portfoliobutton;
    private ImageButton profilpicface;
    private ImageButton historybutton;
    private ImageButton Sosbutton;
    private ImageButton autoevalbutton;


    private ImageButton checkicon;
    private ImageButton homeicon;
    private ImageButton historyicon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checkup_button = (ImageButton)findViewById(R.id.checkup_button);
        checkup_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openCheck_up();
            }
        });

        portfoliobutton = (ImageButton)findViewById(R.id.portfolioboutton);
        portfoliobutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPortfolio();
            }
        });

        profilpicface = (ImageButton) findViewById(R.id.profilpicface);
        profilpicface.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openProfil();
            }
        });

        historybutton = (ImageButton) findViewById(R.id.historybutton);
        historybutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openHistory();
            }
        });

        Sosbutton = (ImageButton) findViewById(R.id.sosbutton);
        Sosbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openSos();
            }
        });
        autoevalbutton = (ImageButton) findViewById(R.id.autoevalbutton);
        autoevalbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openautoeval();
            }
        });

        checkicon = (ImageButton)findViewById(R.id.imageView37);
        checkicon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openCheck_up();
            }
        });
        historyicon = (ImageButton)findViewById(R.id.imageView33);
        historyicon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openHistory();
            }
        });
        homeicon = (ImageButton)findViewById(R.id.imageView38);
        homeicon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openMain();
            }
        });
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
    public void openHistory(){
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
    public void openSos(){
        Intent intent = new Intent(this, SosActivity.class);
        startActivity(intent);
    }
    public void openautoeval(){
        Intent intent = new Intent(this, AutoevaluationActivity.class);
        startActivity(intent);
    }


    public void openMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}