package com.example.ebbabusch.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAccelerometer (View view) {
        Intent intent = new Intent(this, RunAccelerometer.class);
        startActivity(intent);
    }

    public void onClickCompass (View view) {
        Intent intent = new Intent(this, RunCompass.class);
        startActivity(intent);
    }
}
