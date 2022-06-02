package com.example.premiertry;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
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



    CheckBox feelfaint,chestpain,cough,feelstiff,outofbreath,headache;
    Button buttonOrder;
    EditText other;
    ImageButton btn;
    SeekBar seekbar;
    private TextView eventDateTV, eventTimeTV;
    private LocalTime time;
    private DataBaseHelper dataBaseHelper= new DataBaseHelper(AutoevaluationActivity.this);

    @RequiresApi(api = Build.VERSION_CODES.O)
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

        feelfaint =  findViewById(R.id.feelfaint);
        chestpain =  findViewById(R.id.chestpain);
        cough =  findViewById(R.id.Cough);
        feelstiff =  findViewById(R.id.feelstiff);
        outofbreath =  findViewById(R.id.outofbreath);
        headache =  findViewById(R.id.headache);
        other = findViewById(R.id.other);
        btn = findViewById(R.id.GoBackArrow);
        buttonOrder =  findViewById(R.id.button);
        seekbar =  findViewById(R.id.painlevel);
        eventTimeTV = findViewById(R.id.eventTimeTV);
        seekbar.setMax(10);

    }


    public void saveEventAction(View view)
    {

        StringBuilder result = new StringBuilder();

        int seekBarValue= seekbar.getProgress();
        result.append("Pain level:"+seekBarValue);
        result.append(", Symptoms: ");

        if (feelfaint.isChecked()) {

            result.append(" sympt1");
        }
        if (chestpain.isChecked()) {

            result.append(" sympt2");
        }
        if (cough.isChecked()) {

            result.append(" sympt3");
        }
        if (feelstiff.isChecked()) {

            result.append(" sympt4");
        }
        if (outofbreath.isChecked()) {

            result.append(" sympt5");
        }
        if (headache.isChecked()) {

            result.append(" sympt6 ");
        }

        result.append(" Other mentions: ");
        String eventName = other.getText().toString();
        result.append(eventName);

        // interessting for data base as it is here that you have all required data
        Event newEvent = new Event(result.toString(), CalendarUtils.selectedDate, time);
        Event.eventsList.add(newEvent);

        //TodayEvaluation tEval=new TodayEvaluation(-1,CalendarUtils.selectedDate.toString(),seekBarValue,headache.toString(),outofbreath.toString());







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