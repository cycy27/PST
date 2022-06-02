package com.example.premiertry;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;


import java.time.LocalTime;


public class AutoevaluationActivity extends AppCompatActivity {

    CheckBox sympt1,sympt2,sympt3,sympt4, sympt5, sympt6;
    Button buttonOrder;
    EditText editText;
    ImageButton btn;
    SeekBar seekbar;
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
        sympt1 =  findViewById(R.id.feelfaint);
        sympt2 =  findViewById(R.id.chestpain);
        sympt3 =  findViewById(R.id.Cough);
        sympt4 =  findViewById(R.id.feelstiff);
        sympt5 =  findViewById(R.id.outofbreath);
        sympt6 =  findViewById(R.id.headache);
        editText = findViewById(R.id.other);
        btn = findViewById(R.id.GoBackArrow);
        buttonOrder =  findViewById(R.id.button);
        seekbar =  findViewById(R.id.painlevel);
        eventTimeTV = findViewById(R.id.eventTimeTV);
        editText = findViewById(R.id.other);
        seekbar.setMax(10);

    }

    public void saveEventAction(View view)
    {
        StringBuilder result = new StringBuilder();

        int seekBarValue= seekbar.getProgress();
        result.append("Pain level:"+seekBarValue);
        result.append(", Symptoms: ");

        if (sympt1.isChecked()) {

            result.append(" sympt1");
        }
        if (sympt2.isChecked()) {

            result.append(" sympt2");
        }
        if (sympt3.isChecked()) {

            result.append(" sympt3");
        }
        if (sympt4.isChecked()) {

            result.append(" sympt4");
        }
        if (sympt5.isChecked()) {

            result.append(" sympt5");
        }
        if (sympt6.isChecked()) {

            result.append(" sympt6 ");
        }

        result.append(" Other mentions: ");
        String eventName = editText.getText().toString();
        result.append(eventName);

        // interessting for data base as it is here that you have all required data
        Event newEvent = new Event(result.toString(), CalendarUtils.selectedDate, time);
        Event.eventsList.add(newEvent);

        finish();
    }

    public void addListenerOnButtonClick() {

        btn = (ImageButton)findViewById(R.id.GoBackArrow);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                finish();
            }
        });





    }

}