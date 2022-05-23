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


public class Autoevaluation extends AppCompatActivity {
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
    }


    public void saveEventAction(View view)
    {

        StringBuilder result = new StringBuilder();

        int seekBarValue= seekbar.getProgress();
        result.append("Painlevel:"+seekBarValue);
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


        String eventName = editText.getText().toString();
        result.append(eventName);
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

        //Applying the Listener on the Button click
        /*
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
*/




    }

    }