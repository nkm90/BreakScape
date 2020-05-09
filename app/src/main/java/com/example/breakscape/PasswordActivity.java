package com.example.breakscape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class PasswordActivity extends AppCompatActivity {

    GridView gridView;
    String[] values = {
            "Staff_1","Staff_2","Staff_3","Staff_4"
    };
    int[] icons = {
            R.drawable.staff1, R.drawable.staff2, R.drawable.staff3, R.drawable.staff4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        GridView gridView = (GridView) findViewById(R.id.gridview);

        final GridAdapter gridAdapter = new GridAdapter(this, values, icons);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = null;
                if(position == 0){
                    myIntent = new Intent(view.getContext(), fullPassActivity.class);
                    //passing array index
                    myIntent.putExtra("position", position);
                }
                else if (position == 1){
                    myIntent = new Intent(view.getContext(), fullPassActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 2){
                    myIntent = new Intent(view.getContext(), fullPassActivity.class);
                    myIntent.putExtra("position", position);
                }
                else if(position == 3){
                    myIntent = new Intent(view.getContext(), fullPassActivity.class);
                    myIntent.putExtra("position", position);
                }
                startActivity(myIntent);
            }
        });
    }
}