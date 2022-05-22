package com.example.premiertry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Singup extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText name, email, password, confirmPassword;

    private Button buttoncontinuesu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        mAuth = FirebaseAuth.getInstance();

        name = findViewById(R.id.namesu);
        email = findViewById(R.id.emailpersonsu);
        password = findViewById(R.id.pswd);
        confirmPassword = findViewById(R.id.confirmpswd);

        buttoncontinuesu = (Button) findViewById(R.id.buttoncontinuesu);
        buttoncontinuesu.setOnClickListener(v -> openwelcome3());
    }

    public void openwelcome3(){

        String nameValue = name.getText().toString().trim();
        String emailValue = email.getText().toString().trim();
        String passwordValue = password.getText().toString().trim();
        String confirmPasswordValue = confirmPassword.getText().toString().trim();

        //check if the passwords are the same here:

        mAuth.createUserWithEmailAndPassword(emailValue,passwordValue).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                User user = new User(nameValue,emailValue);

                FirebaseDatabase.getInstance("https://pst3a-82c4d-default-rtdb.europe-west1.firebasedatabase.app/")
                        .getReference("Users").child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser().getUid()))
                        .setValue(user).addOnCompleteListener(task1 -> {
                            if(task1.isSuccessful()){
                                startActivity(new Intent(this, MainActivity.class));

                            }
                });
            }
        });
    }
}