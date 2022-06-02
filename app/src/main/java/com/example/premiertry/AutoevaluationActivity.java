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
import android.widget.Toast;


import java.time.LocalDate;
import java.time.LocalTime;


public class AutoevaluationActivity extends AppCompatActivity {



    CheckBox feelfaint,chestpain,cough,feelstiff,outofbreath,headache;
    Boolean feelfaintBool=false,chestpainBool=false,coughBool=false,feelstiffBool=false,outofbreathBool=false,headacheBool=false;
    Button buttonOrder;
    EditText other;
    ImageButton btn;
    SeekBar seekbar;
    private TextView eventDateTV, eventTimeTV;
    private LocalTime time;
    private LocalDate date;
    private DataBaseHelper dataBaseHelper= new DataBaseHelper(AutoevaluationActivity.this);

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoevaluation);
        initWidgets();
        time = LocalTime.now();
        if(CalendarUtils.selectedDate == null){
            this.date= LocalDate.now();
            eventDateTV.setText("Date: " + CalendarUtils.formattedDate(date));
        }else{
            this.date= CalendarUtils.selectedDate;
            eventDateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        }


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

            result.append(" Faint");
            feelfaintBool=true;
        }
        if (chestpain.isChecked()) {

            result.append(" ,Chest pain");
            chestpainBool=true;
        }
        if (cough.isChecked()) {

            result.append(" ,Cough");
            coughBool=true;
        }
        if (feelstiff.isChecked()) {

            result.append(" ,Stiffness");
            feelstiffBool=true;
        }
        if (outofbreath.isChecked()) {

            result.append(" ,Out of Breath");
            outofbreathBool=true;
        }
        if (headache.isChecked()) {

            result.append(" ,headache");
            headacheBool=true;
        }

        result.append(" Other mentions: ");
        String eventName = other.getText().toString();
        result.append(eventName);

        // interessting for data base as it is here that you have all required data
        Event newEvent = new Event(result.toString(), CalendarUtils.selectedDate, time);
        Event.eventsList.add(newEvent);

        //Toast.makeText(AutoevaluationActivity.this, "date: "+date,Toast.LENGTH_SHORT).show();
        TodayEvaluation tEval=new TodayEvaluation(-1,""+date,
                seekBarValue,
                headacheBool,
                outofbreathBool,
                feelstiffBool,
                chestpainBool,
                feelfaintBool,
                coughBool,
                ""+other.getText().toString());
        boolean done= dataBaseHelper.addEvaluation(tEval);
        if(!done)
            Toast.makeText(AutoevaluationActivity.this, "Error adding to Database!",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(AutoevaluationActivity.this, "Added to Database!",Toast.LENGTH_SHORT).show();








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