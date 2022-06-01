package com.example.premiertry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome2 extends AppCompatActivity {
    private Button buttonqr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome2);

        buttonqr = (Button) findViewById(R.id.buttonqr);
        buttonqr.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                openwelcome3();
            }
        });

    }
    public void openwelcome3() {
        Intent intent = new Intent(this, Welcome3.class);
        startActivity(intent);

    }

}