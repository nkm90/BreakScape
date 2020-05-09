package com.example.breakscape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class fullPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_pass);
        // Get intent data
        Intent i = getIntent();
        // Get Selected Image Id
        int position = i.getExtras().getInt("position");
        StaffAdapter imageFullAdapter = new StaffAdapter(this);
        ImageView imageView = (ImageView) findViewById(R.id.full_view);
        imageView.setImageResource(imageFullAdapter.staff[position]);
    }
}
