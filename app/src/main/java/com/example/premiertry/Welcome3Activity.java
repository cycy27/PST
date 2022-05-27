package com.example.premiertry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Welcome3Activity extends AppCompatActivity {

    private ImageView Buttonnextw3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome3);
        Buttonnextw3 = (ImageView) findViewById(R.id.Buttonnextw3);
        Buttonnextw3.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v){
                openMainActivity();
            }
        });
    }
    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}