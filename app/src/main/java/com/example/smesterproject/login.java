package com.example.smesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {


    TextView reg ;
    EditText name , password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=(Button) findViewById(R.id.btn_login) ;
        reg=(TextView) findViewById(R.id.register);
        name=(  EditText) findViewById(R.id.id_username) ;
        password=(EditText) findViewById(R.id.id_pass);


        DBHelper db=new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txtName=name.getText().toString();
                String txtPassword=password.getText().toString();

                if (txtName.equals("")|| txtPassword.equals(""))
                    Toast.makeText( login.this , "please enter all fields" , Toast.LENGTH_SHORT).show();
                else{

                    Boolean checkuserpass = db.checkpassword( txtName ,txtPassword);
                    if (checkuserpass==true){
                        Toast.makeText(login.this, "login", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent( getApplicationContext(), Home1.class);
                        startActivity(intent);

                    } else {

                        Toast.makeText(login.this, "login failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent( login.this, MainActivity.class);
                startActivity(intent);
            }
        });








    }
}
