package com.example.smesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class dessert extends AppCompatActivity {


    ListView simpleList;
    String[] desertlist = {"Cake", "Roll Cake", "Cup Cake"};
    int name[] ={R.drawable.kk,R.drawable.roll,R.drawable.cupcake};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);

        simpleList = (ListView) findViewById(R.id.simpleListView);
       CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), desertlist, name);
        simpleList.setAdapter(customAdapter);
    }
}