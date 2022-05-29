package com.example.premiertry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.List;


public class SignupActivity extends AppCompatActivity {

    //private FirebaseAuth mAuth;
    private EditText name, email, password, confirmPassword;

    private Button buttoncontinuesu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //mAuth = FirebaseAuth.getInstance();

        name = findViewById(R.id.namesu);
        email = findViewById(R.id.emailpersonsu);
        password = findViewById(R.id.pswd);
        confirmPassword = findViewById(R.id.confirmpswd);
        buttoncontinuesu = (Button) findViewById(R.id.buttoncontinuesu);

        //button listeners
        buttoncontinuesu.setOnClickListener(view -> {
                    User user;
                    try{

                        user= new User(-1,name.getText().toString(),email.getText().toString(),password.getText().toString());
                        Toast.makeText(SignupActivity.this, user.toString(),Toast.LENGTH_SHORT).show();


                    }catch(Exception e){
                        Toast.makeText(SignupActivity.this, "error",Toast.LENGTH_SHORT).show();
                        user= new User(-1,"error","error","error");

                    }
                    DataBaseHelper dataBaseHelper= new DataBaseHelper(SignupActivity.this);
                    List<User> allUsers= dataBaseHelper.getAllUsers();
                    //boolean done= dataBaseHelper.addOne(user);
                    Toast.makeText(SignupActivity.this, "users: "+ allUsers.toString(),Toast.LENGTH_SHORT).show();

                }

                //User user = new User(name.getText().toString(),email.getText().toString(),password.getText().toString());
        );
    }

    public void openwelcome3(){

        String nameValue = name.getText().toString().trim();
        String emailValue = email.getText().toString().trim();
        String passwordValue = password.getText().toString().trim();
        String confirmPasswordValue = confirmPassword.getText().toString().trim();

        ActionUser au= new ActionUser();

        //check if the passwords are the same here:

        /*mAuth.createUserWithEmailAndPassword(emailValue,passwordValue).addOnCompleteListener(task -> {
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
        });*/
    }
}