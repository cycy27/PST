package com.example.premiertry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ProfilActivity extends AppCompatActivity {
    private ImageButton profilSubmitBtn,profilHelpBtn;
    private EditText profilAdress,profilEmail,profilNumber,profilAge,profilWeight;
    private EditText profilHeight,profilContactName,profilContactNumber;
    private TextView SignInEmailError,SignInPasswordError;
    private RadioGroup profilSexRadio, profilSmokingRadio;
    private RadioButton profilSexButton,profilSmokingButton;
    private DataBaseHelper dataBaseHelper= new DataBaseHelper(ProfilActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);


        profilAdress=findViewById(R.id.editTextTextMultiLine);
        profilEmail=findViewById(R.id.editTextTextEmailAddress);
        profilNumber=findViewById(R.id.editTextPhone);
        profilAge=findViewById(R.id.editTextNumber2);
        profilWeight=findViewById(R.id.editTextNumber);
        profilHeight=findViewById(R.id.editTextNumber4);
        profilContactName=findViewById(R.id.editTextTextPersonName);
        profilContactNumber=findViewById(R.id.editTextPhone2);
        profilSexRadio = findViewById(R.id.sex);
        profilSmokingRadio = findViewById(R.id.smoking);
        profilSubmitBtn = findViewById(R.id.submitbutton);
        profilHelpBtn = findViewById(R.id.helpButton);

        profilSubmitBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedGender = profilSexRadio.getCheckedRadioButtonId();
                int selectedSmokingStatus = profilSmokingRadio.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                profilSexButton =findViewById(selectedGender);
                profilSmokingButton =findViewById(selectedSmokingStatus);
                Profil profil;
                try{
                    profil= new Profil(-1,profilAdress.getText().toString(),profilEmail.getText().toString(),profilNumber.getText().toString(),Integer.parseInt(profilAge.getText().toString()),
                            Integer.parseInt(profilWeight.getText().toString()),Integer.parseInt(profilHeight.getText().toString()),profilSexButton.getText().toString(),profilSmokingButton.getText().toString(),
                            profilContactName.getText().toString(),profilContactNumber.getText().toString());
                    Toast.makeText(ProfilActivity.this, "Added to DataBase",Toast.LENGTH_SHORT).show();

                }catch(Exception e){
                    Toast.makeText(ProfilActivity.this, "error",Toast.LENGTH_SHORT).show();
                    profil= new Profil(-1,"error","error","error",-1,-1,-1,"error","error","error","error");

                }
                //boolean done= dataBaseHelper.addOneProfil(profil);


                Toast.makeText(ProfilActivity.this,
                        profilSexButton.getText(), Toast.LENGTH_SHORT).show();

                openMain();
            }

        });

        profilHelpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHelp();

            }
        });

    }
    public void openHelp(){
        Intent intent = new Intent(this, HelpActivity.class);
        //intent.putExtra("userID",)
        startActivity(intent);
    }
    public void openMain(){
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("userID",)
        startActivity(intent);
    }

}