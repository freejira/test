package com.example.motion_sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView x_gravity, y_gravity, z_gravity;
    TextView x_accelerometer, y_accelerometer, z_accelerometer;
    TextView x_linear_acceleration, y_linear_acceleration, z_linear_acceleration;
    TextView x_gyroscope, y_gyroscope, z_gyroscope;

    SensorManager sm;

    Sensor sensor_gravity, sensor_accelerometer, sensor_linear_acceleration, sensor_gyroscope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        x_gravity = (TextView) findViewById(R.id.x_gravity);
        y_gravity = (TextView) findViewById(R.id.y_gravity);
        z_gravity = (TextView) findViewById(R.id.z_gravity);

        x_accelerometer = (TextView) findViewById(R.id.x_accelerometer);
        y_accelerometer = (TextView) findViewById(R.id.y_accelerometer);
        z_accelerometer = (TextView) findViewById(R.id.z_accelerometer);

        x_linear_acceleration = (TextView) findViewById(R.id.x_linear_acceleration);
        y_linear_acceleration = (TextView) findViewById(R.id.y_linear_acceleration);
        z_linear_acceleration = (TextView) findViewById(R.id.z_linear_acceleration);

        x_gyroscope = (TextView) findViewById(R.id.x_gyroscope);
        y_gyroscope = (TextView) findViewById(R.id.y_gyroscope);
        z_gyroscope = (TextView) findViewById(R.id.z_gyroscope);


        sm = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensor_gravity = sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensor_accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor_linear_acceleration = sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensor_gyroscope = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

    }


    @Override
    protected void onPostResume() {
        super.onPostResume();

        sm.registerListener((SensorEventListener) this, sensor_gravity, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener((SensorEventListener) this, sensor_accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener((SensorEventListener) this, sensor_linear_acceleration, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener((SensorEventListener) this, sensor_gyroscope, SensorManager.SENSOR_DELAY_NORMAL);


    }


    @Override
    protected void onPause() {
        super.onPause();

        sm.unregisterListener((SensorListener) this);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }


    @Override
    public void onSensorChanged(SensorEvent event){

        switch (event.sensor.getType()){

            case Sensor.TYPE_GRAVITY:
                x_gravity.setText("X: " + event.values[0]);
                y_gravity.setText("Y: " + event.values[1]);
                z_gravity.setText("Z: " + event.values[2]);
                break;


            case Sensor.TYPE_ACCELEROMETER:
                x_accelerometer.setText("X: " + event.values[0]);
                y_accelerometer.setText("Y: " + event.values[1]);
                z_accelerometer.setText("Z: " + event.values[2]);
                break;


            case Sensor.TYPE_LINEAR_ACCELERATION:
                x_linear_acceleration.setText("X: " + event.values[0]);
                y_linear_acceleration.setText("Y: " + event.values[1]);
                z_linear_acceleration.setText("Z: " + event.values[2]);
                break;


            case Sensor.TYPE_GYROSCOPE:
                x_gyroscope.setText("X: " + event.values[0]);
                y_gyroscope.setText("Y: " + event.values[1]);
                z_gyroscope.setText("Z: " + event.values[2]);
                break;

        }

    }

}