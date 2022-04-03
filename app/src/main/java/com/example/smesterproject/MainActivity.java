package com.example.smesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView reg , name , password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reg=(TextView) findViewById(R.id.register);
        name=(TextView) findViewById(R.id.id_username) ;
        password=(TextView) findViewById(R.id.id_pass);

        login=(Button) findViewById(R.id.btn_login) ;

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, register.class);
                startActivity(intent);
            }
        });

    }
}