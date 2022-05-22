package com.example.test;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.TextView;


import com.google.android.material.slider.Slider;

import java.time.LocalTime;


public class Autoevaluation extends AppCompatActivity {
    CheckBox sympt1,sympt2,sympt3,sympt4, sympt5, sympt6;
    Button buttonOrder;
    EditText editText;
    ImageButton btn;
    Slider.OnSliderTouchListener touchListener;
    Slider slider;
    private TextView eventDateTV, eventTimeTV;
    private LocalTime time;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoevaluation);
        initWidgets();
        time = LocalTime.now();
        eventDateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        eventTimeTV.setText("Time: " + CalendarUtils.formattedTime(time));
        addListenerOnButtonClick();

    }

    private void initWidgets()
    {

        eventDateTV = findViewById(R.id.eventDateTV);

        sympt1 = (CheckBox) findViewById(R.id.feelfaint);
        sympt2 = (CheckBox) findViewById(R.id.chestpain);
        sympt3 = (CheckBox) findViewById(R.id.Cough);
        sympt4 = (CheckBox) findViewById(R.id.feelstiff);
        sympt5 = (CheckBox) findViewById(R.id.outofbreath);
        sympt6 = (CheckBox) findViewById(R.id.headache);
        editText = (EditText)findViewById(R.id.other);
        btn = (ImageButton)findViewById(R.id.GoBackArrow);
        buttonOrder = (Button) findViewById(R.id.button);
        slider = (Slider) findViewById(R.id.slider);
        eventTimeTV = findViewById(R.id.eventTimeTV);
    }

    public void saveEventAction(View view)
    {

        StringBuilder result = new StringBuilder();
        String eventSympt1 = "", eventSympt2 = "", eventSympt3 = "", eventSympt4 = "", eventSympt5 = "", eventSympt6 = null;
        if (sympt1.isChecked()) {
            eventSympt1 = sympt1.getText().toString();
        }
        if (sympt2.isChecked()) {
           eventSympt2 = sympt2.getText().toString();
        }
        if (sympt3.isChecked()) {
            eventSympt3 = sympt3.getText().toString();
        }
        if (sympt4.isChecked()) {
            eventSympt4 = sympt4.getText().toString();
        }
        if (sympt5.isChecked()) {
            eventSympt5 = sympt5.getText().toString();
        }
        if (sympt6.isChecked()) {
            eventSympt6 = sympt6.getText().toString();
        }
        String eventadd = editText.getText().toString();

        Event newEvent = new Event(eventSympt1, eventSympt2, eventSympt3, eventSympt4, eventSympt5, eventSympt6, CalendarUtils.selectedDate, time);
        Event.eventsList.add(newEvent);
        finish();
    }



    public void addListenerOnButtonClick() {
        //Getting instance of CheckBoxes and Button from the activity_autoevaluation.xml file
        sympt1 = (CheckBox) findViewById(R.id.feelfaint);
        sympt2 = (CheckBox) findViewById(R.id.chestpain);
        sympt3 = (CheckBox) findViewById(R.id.Cough);
        sympt4 = (CheckBox) findViewById(R.id.feelstiff);
        sympt5 = (CheckBox) findViewById(R.id.outofbreath);
        sympt6 = (CheckBox) findViewById(R.id.headache);
        editText = (EditText)findViewById(R.id.other);
        btn = (ImageButton)findViewById(R.id.GoBackArrow);
        buttonOrder = (Button) findViewById(R.id.button);
        slider = (Slider) findViewById(R.id.slider);


        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
            });



        //Applying the Listener on the Button click
        buttonOrder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {




                StringBuilder result = new StringBuilder();
                result.append("Selected Items:");
                //result.append(slide_value);
                if (sympt1.isChecked()) {
                    result.append("\nSymptom 1");
                }
                if (sympt2.isChecked()) {
                    result.append("\nSymptom 2");

                }
                if (sympt3.isChecked()) {
                    result.append("\nSymptom 3");
                }
                if (sympt4.isChecked()) {
                    result.append("\nSymptom 4");

                }
                if (sympt5.isChecked()) {
                    result.append("\nSymptom 5");

                }
                if (sympt6.isChecked()) {
                    result.append("\nSymptom 6\n");
                }
                String name = editText.getText().toString();
                result.append(name);
                //Displaying the message on the toast
                Toast.makeText(getApplicationContext(), result.toString() , Toast.LENGTH_LONG).show();
            }

        });





    }

    }