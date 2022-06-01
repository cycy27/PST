package com.example.premiertry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

<<<<<<<< HEAD:app/src/main/java/com/example/premiertry/Welcome3.java
public class Welcome3 extends AppCompatActivity {
========
public class Welcome3Activity extends AppCompatActivity {
>>>>>>>> origin/christryn°2:app/src/main/java/com/example/premiertry/Welcome3Activity.java

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