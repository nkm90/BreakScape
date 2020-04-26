package com.example.breakscape;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AbsRuntimePermission extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager(). getDefaultDisplay();
        Point size = new Point();
        display. getSize(size);
        Log.e("%theSize%" ,""+ size.y);
        if(size.y < 2393){
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
        }
    }

}
