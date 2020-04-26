package com.example.breakscape;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public abstract class AbsRuntimePermission extends AppCompatActivity {
     static String teamName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager(). getDefaultDisplay();
        Point size = new Point();
        display. getSize(size);
        if(size.y < 2393){
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
        }
    }

}
