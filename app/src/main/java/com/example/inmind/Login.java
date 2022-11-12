package com.example.inmind;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {


    Button loginbtn, registerbtn;
    TextInputEditText email, password;

    public Login(){

    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginbtn = findViewById(R.id.loginbtn);
        registerbtn = findViewById(R.id.register_login_btn);
        email = findViewById(R.id.Siemail);
        password = findViewById(R.id.Sipassword);



        loginbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Log.v("Login","helloooooo");
                Intent i = new Intent(Login.this, HomeActivity.class);
                startActivity(i);
                CleanFields();

            }
        });


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Login.this, Register.class);
                startActivity(i1);
            }
        });

//        registerbtn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(Login.this, Register.class);
//                startActivity(i);
//
//
//            }
//        });


    }



    public void CleanFields()
    {
        email.setText("");
        password.setText("");

    }



}