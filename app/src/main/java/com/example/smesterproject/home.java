package com.example.smesterproject;

//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class home extends AppCompatActivity {
    Button btnhome, btnabout, btncontact, btncart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnhome = findViewById(R.id.fbtn1);
        btnabout = findViewById(R.id.fbtn2);
        btncontact = findViewById(R.id.fbtn3);
        btncart = findViewById(R.id.fbtn5);

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                Intent intent = new Intent(home.this, home.class);
                startActivity(intent);

            }

        });

        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replaceFragment(new aboutf());
            }
        });


        btncontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replaceFragment(new contactf());
            }
        });
    }
    private void replaceFragment(Fragment fragments) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragments);
        fragmentTransaction.commit();
    }

    }
