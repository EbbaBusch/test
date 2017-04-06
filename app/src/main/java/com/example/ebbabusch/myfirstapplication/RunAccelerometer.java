package com.example.ebbabusch.myfirstapplication;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/* code from developer.android.com */
public class RunAccelerometer extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private float[] linear_acceleration = new float[3];
    public String x;
    public String y;
    public String z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_accelerometer);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this, mAccelerometer);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //nothing to add here
    }

    public void onSensorChanged(SensorEvent event) {

        linear_acceleration[0] = event.values[0];
        linear_acceleration[1] = event.values[1];
        linear_acceleration[2] = event.values[2];

        x = String.valueOf(linear_acceleration[0]);
        TextView textViewX = (TextView) findViewById(R.id.viewX);
        textViewX.setText(x);

        y = String.valueOf(linear_acceleration[1]);
        TextView textViewY = (TextView) findViewById(R.id.viewY);
        textViewY.setText(y);

        z = String.valueOf(linear_acceleration[2]);
        TextView textViewZ = (TextView) findViewById(R.id.viewZ);
        textViewZ.setText(z);
    }
}