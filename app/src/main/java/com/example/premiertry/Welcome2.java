package com.example.premiertry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

<<<<<<<< HEAD:app/src/main/java/com/example/premiertry/Welcome2.java
public class Welcome2 extends AppCompatActivity {
========
public class Welcome2Activity extends AppCompatActivity {
>>>>>>>> origin/christryn°2:app/src/main/java/com/example/premiertry/Welcome2Activity.java
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
<<<<<<<< HEAD:app/src/main/java/com/example/premiertry/Welcome2.java
        Intent intent = new Intent(this, Welcome3.class);
========
        Intent intent = new Intent(this, Welcome3Activity.class);
>>>>>>>> origin/christryn°2:app/src/main/java/com/example/premiertry/Welcome2Activity.java
        startActivity(intent);

    }

}