package com.example.smesterproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class HomeFragment extends Fragment {

    public Button btndrinks , btndessert , btnjunkfood ,btnicecream;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btndrinks = (Button) view.findViewById(R.id.btndrinks);
        btndessert= (Button) view.findViewById(R.id.btndessert) ;
        btnjunkfood= (Button) view.findViewById(R.id.btnjunkfood);
        btnicecream= (Button) view.findViewById(R.id.btnicecream);
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_home, container, false);

        btndrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), drinks.class);
                startActivity(intent);
            }
        });

        btndessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), dessert.class);
                startActivity(intent);
            }
        });

        btnjunkfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), junkfood.class);
                startActivity(intent);
            }
        });

        btnicecream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), icecream.class);
                startActivity(intent);
            }
        });



        return view;
    }
}


