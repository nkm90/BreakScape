package com.example.breakscape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

public class EncryptionActivity extends AppCompatActivity {

    GridView gridView;
    String[] values = {
            "Evidence_1","Evidence_2","Evidence_3","Evidence_4"
    };
    int[] icons = {
            R.drawable.e1, R.drawable.e2, R.drawable.e3, R.drawable.e4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);

        GridView gridView = (GridView) findViewById(R.id.gridview);

        final GridAdapter gridAdapter = new GridAdapter(this, values, icons);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = null;
                if(position == 0){
                    myIntent = new Intent(view.getContext(), fullEncActivity.class);
                    //passing array index
                    myIntent.putExtra("position", position);
                }
                else if (position == 1){
                    myIntent = new Intent(view.getContext(), fullEncActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 2){
                    myIntent = new Intent(view.getContext(), fullEncActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 3){
                    myIntent = new Intent(view.getContext(), fullEncActivity.class);
                    myIntent.putExtra("position", position);
                }
                startActivity(myIntent);
            }
        });
    }
}