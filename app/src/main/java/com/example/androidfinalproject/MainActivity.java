package com.example.androidfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_userName, et_password;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Android Final Exam : Login Screen");

        et_userName = findViewById(R.id.et_userName);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);

        final Auth auth = new Auth();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(et_userName.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "Please Fill Username ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(et_password.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "Please Fill Password ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!(et_userName.getText().toString().equalsIgnoreCase(auth.getUsername()))){
                    Toast.makeText(MainActivity.this, "Incorrect Username : Please Enter A Valid Username", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!(et_password.getText().toString().equalsIgnoreCase(auth.getPassword()))){
                    Toast.makeText(MainActivity.this, "Incorrect Password : Please Enter A Valid Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(MainActivity.this, CountriesActivity.class);

                startActivity(i);
                finish();
            }
        });
    }
}