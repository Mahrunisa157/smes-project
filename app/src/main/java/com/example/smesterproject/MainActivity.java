package com.example.smesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name , password , repassword;
    Button login, reg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= (EditText) findViewById(R.id.id_username1);
        password= (EditText) findViewById(R.id.id_pass1) ;
        repassword= (EditText) findViewById(R.id.id_repass) ;
        login=(Button) findViewById(R.id.btn_login) ;
        reg=(Button) findViewById(R.id.btn_submit);
        DBHelper db=new DBHelper(this);


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = name.getText().toString();
                String pass1 = password.getText().toString();
                String pass= repassword.getText().toString();
                if(user.equals("") || pass1.equals("") || pass.equals(""))
                    Toast.makeText( MainActivity.this , "please enter all fields" , Toast.LENGTH_SHORT).show();
                else{
                    if(pass1.equals(pass)){
                        Boolean checkuser = db.checkname(user);
                        if (checkuser==false){
                            Boolean insert = db.insertData(user , pass1);
                            if (insert==true){
                                Toast.makeText(MainActivity.this, "registered successfully" , Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent ( getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(MainActivity.this, "registration failed" , Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "User Already Exist" , Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(MainActivity.this, "Password does not match" , Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this , login.class);
                startActivity(intent);
            }
        });



    }
}