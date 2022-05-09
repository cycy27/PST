package com.example.premiertry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Singup extends AppCompatActivity {

    private Button buttoncontinuesu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        buttoncontinuesu = (Button) findViewById(R.id.buttoncontinuesu);
        buttoncontinuesu.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v){
                openwelcome3();
            }
        });
    }

    public void openwelcome3(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}