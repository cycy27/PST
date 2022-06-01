package com.example.premiertry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Singup extends AppCompatActivity {



    private Button SignUpContinue;
    private EditText SignUpName,SignUpEmail,SignUpPassword,SignUpConfirmPassword;
    private TextView SignUpNameError,SignUpEmailError,SignUpPasswordError,SignUpConfirmPassError;
    private DataBaseHelper dataBaseHelper= new DataBaseHelper(Singup.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        SignUpName=findViewById(R.id.SignUpName);
        SignUpContinue=findViewById(R.id.SignUpContinue);
        SignUpEmail=findViewById(R.id.SignUpEmail);
        SignUpPassword=findViewById(R.id.SignUpPassword);
        SignUpConfirmPassword=findViewById(R.id.SignUpConfirmPassword);
        //message
        SignUpNameError=findViewById(R.id.nameAlert);
        SignUpEmailError=findViewById(R.id.emailAlert);
        SignUpPasswordError=findViewById(R.id.paswordAlert);
        SignUpConfirmPassError=findViewById(R.id.confirmPassAlert);

        SignUpContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validateName() && validateEmail() && validatePassword()){
                    User user;
                    try{
                        user= new User(-1,SignUpName.getText().toString(),SignUpEmail.getText().toString(),SignUpPassword.getText().toString());
                        //Toast.makeText(Singup.this, user.toString(),Toast.LENGTH_SHORT).show();

                    }catch(Exception e){
                        Toast.makeText(Singup.this, "error",Toast.LENGTH_SHORT).show();
                        user= new User(-1,"error","error","error");

                    }
                    boolean done= dataBaseHelper.addOne(user);
                    if(!done)
                        Toast.makeText(Singup.this, "Error adding to Database!",Toast.LENGTH_SHORT).show();
                    else
                        openWelcome3();

                    //List<User> allUsers= dataBaseHelper.getAllUsers(); // get users
                    //boolean done= dataBaseHelper.addOne(user); //add users
                    //Toast.makeText(Singup.this, "users: "+ allUsers.toString(),Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
    private boolean validateName() {
        String nameInput = SignUpName.getText().toString().trim();
        if (nameInput.isEmpty()) {
            SignUpNameError.setText("Field can't be empty");
            return false;
        }else{
            SignUpNameError.setText("");
            return true;
        }
    }
    private boolean validateEmail() {
        String emailInput = SignUpEmail.getText().toString().trim();
        if (emailInput.isEmpty()) {
            SignUpEmailError.setText("Field can't be empty");
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            SignUpEmailError.setText("Please enter a valid email address");
            return false;
        } else {
            SignUpEmailError.setText("");
            if (!dataBaseHelper.checkUser(emailInput)){
                return true;
            }
            else {
                SignUpEmailError.setText("E-mail already exists! Try to sign in");
                return false;
            }
        }
    }
    private boolean validatePassword() {
        String passwordInput = SignUpPassword.getText().toString().trim();
        String ConfirmpasswordInput = SignUpConfirmPassword.getText().toString().trim();
        if (passwordInput.isEmpty()) {
            SignUpPasswordError.setText("Field can't be empty");
            return false;
        }  if (passwordInput.length()<5) {
            SignUpPasswordError.setText("Password must be at least 5 characters");
            return false;
        }
        if(passwordInput.length()>=5){
            SignUpPasswordError.setText("");
        }
        if (!passwordInput.equals(ConfirmpasswordInput)) {
            SignUpConfirmPassError.setText("Password could not be matched!");
            return false;
        }else {
            SignUpConfirmPassError.setText("Password Matched");
            return true;
        }
    }

    public void openWelcome3(){
        Intent intent = new Intent(this, Welcome3.class);
        startActivity(intent);
    }


    /*private EditText name, email, password, confirmPassword;

    private Button buttoncontinuesu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        //mAuth = FirebaseAuth.getInstance();

        name = findViewById(R.id.namesu);
        email = findViewById(R.id.emailpersonsu);
        password = findViewById(R.id.pswd);
        confirmPassword = findViewById(R.id.confirmpswd);
        buttoncontinuesu = (Button) findViewById(R.id.buttoncontinuesu);

        //button listeners
        buttoncontinuesu.setOnClickListener(view -> {
            if(password.getText().equals(confirmPassword)){
                User user;
                try{

                    user= new User(-1,name.getText().toString(),email.getText().toString(),password.getText().toString());
                    Toast.makeText(Singup.this, user.toString(),Toast.LENGTH_SHORT).show();


                }catch(Exception e){
                    Toast.makeText(Singup.this, "error",Toast.LENGTH_SHORT).show();
                    user= new User(-1,"error","error","error");

                }
                DataBaseHelper dataBaseHelper= new DataBaseHelper(Singup.this);
                boolean done= dataBaseHelper.addOne(user);
                if(!done)
                    Toast.makeText(Singup.this, "Error adding to Database!",Toast.LENGTH_SHORT).show();
                else
                    openWelcome3();

                //List<User> allUsers= dataBaseHelper.getAllUsers(); // get users
                //boolean done= dataBaseHelper.addOne(user); //add users
                //Toast.makeText(Singup.this, "users: "+ allUsers.toString(),Toast.LENGTH_SHORT).show();

            }
            else{
                Toast.makeText(Singup.this, "Passwords do not match! ",Toast.LENGTH_SHORT).show();

            }


        }

                //User user = new User(name.getText().toString(),email.getText().toString(),password.getText().toString());
        );
    }


*/

}


