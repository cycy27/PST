package com.example.premiertry;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Welcome1Activity extends AppCompatActivity {
    private Button loginbutton;
    private Button registerbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome1);

        loginbutton = (Button) findViewById(R.id.loginbutton);
        loginbutton.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v){
                openSignin();
            }
        });

        registerbutton = (Button) findViewById(R.id.registerbutton);
        registerbutton.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v){
                opensingup();
            }
        });


    }

    public void opensingup(){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
    public void openSignin(){
        Intent intent = new Intent(this, SigninActivity.class);
        startActivity(intent);
    }


}