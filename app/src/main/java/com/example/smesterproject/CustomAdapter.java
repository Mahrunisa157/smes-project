package com.example.smesterproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    String dessertlist[];
    int name[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] dessertlist, int[] name) {
        this.context = context;
        this.dessertlist = dessertlist;
        this.name = name;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return dessertlist.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.list, null);
        TextView country = (TextView)           view.findViewById(R.id.textView);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        country.setText(dessertlist[i]);
        icon.setImageResource(name[i]);
        return view;
    }
}
