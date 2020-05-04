package com.example.breakscape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Phishing extends AppCompatActivity {

    GridView gridView;
    String[] values = {
            "Email_1","Email_2","Email_3","Email_4","Email_5","Email_6",
            "Email_7","Email_8","Email_9","Email_10","Email_11","Email_12"
    };
    int[] icons = {
            R.drawable.g1, R.drawable.s1, R.drawable.g2, R.drawable.g3,
            R.drawable.s2, R.drawable.g4, R.drawable.g5, R.drawable.g6,
            R.drawable.g7, R.drawable.g8, R.drawable.g9, R.drawable.s3,
            R.drawable.g10, R.drawable.g11, R.drawable.s4, R.drawable.g12
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phishing);

        GridView gridView = (GridView) findViewById(R.id.gridview);

        final GridAdapter gridAdapter = new GridAdapter(this, values, icons);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = null;
                if(position == 0){
                    myIntent = new Intent(view.getContext(), FullActivity.class);
                    //passing array index
                    myIntent.putExtra("position", position);
                }
                else if (position == 1){
                    myIntent = new Intent(view.getContext(), FullActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 2){
                    myIntent = new Intent(view.getContext(), FullActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 3){
                    myIntent = new Intent(view.getContext(), FullActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 4){
                    myIntent = new Intent(view.getContext(), FullActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 5){
                    myIntent = new Intent(view.getContext(), FullActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 6){
                    myIntent = new Intent(view.getContext(), FullActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 7){
                    myIntent = new Intent(view.getContext(), FullActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 8){
                    myIntent = new Intent(view.getContext(), FullActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 9){
                    myIntent = new Intent(view.getContext(), FullActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 10){
                    myIntent = new Intent(view.getContext(), FullActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 11){
                    myIntent = new Intent(view.getContext(), FullActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 12){
                    myIntent = new Intent(view.getContext(), FullActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 13){
                    myIntent = new Intent(view.getContext(), FullActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 14){
                    myIntent = new Intent(view.getContext(), FullActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 15){
                    myIntent = new Intent(view.getContext(), FullActivity.class);
                    myIntent.putExtra("position", position);
                }
                startActivity(myIntent);
            }
        });
    }
}
