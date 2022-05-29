package com.example.premiertry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class HelpActivity extends AppCompatActivity {
    private ImageButton goback;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        goback = (ImageButton) findViewById(R.id.imageButton);

        editText = findViewById(R.id.editTextTextMultiLine2);

        goback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProtfolio();
            }
        });
    }
    public void openProtfolio() {
        Intent intent = new Intent(this, PortfolioActivity.class);
        startActivity(intent);
    }
    public void saveAction(View view) {
        StringBuilder request = new StringBuilder();
        String query = editText.getText().toString();
        request.append(query);
        finish();

    }

}