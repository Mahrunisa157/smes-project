package com.example.smesterproject;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

public class summary extends AppCompatActivity  implements LoaderManager.LoaderCallbacks<Cursor>{


    public cartAdapter1 mAdapter;
    public static final int LOADER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Button clearthedata = findViewById(R.id.clearthedatabase);

        clearthedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int deletethedata = getContentResolver().delete(OrderContract.OrderEntry.CONTENT_URI, null, null);
            }
        });

        getSupportLoaderManager().initLoader(0, null, this);
        ListView listView = findViewById(R.id.list);
        mAdapter = new cartAdapter1(this, null);
        listView.setAdapter(mAdapter);

    }


    @Override
    public Loader<Cursor> onCreateLoader(int id,  Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_CREAM,
                OrderContract.OrderEntry.COLUMN_HASTOPPING
        };

        return new CursorLoader(this, OrderContract.OrderEntry.CONTENT_URI,
                projection,
                null,
                null,
                null);
    }


    @Override
    public void onLoadFinished( Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset( Loader<Cursor> loader) {

        mAdapter.swapCursor(null);
    }
}