package com.example.widget_event;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_car =(Button) findViewById(R.id.button_car);
        btn_car.setOnClickListener(mClickListener);

        Button btn_airplane =(Button) findViewById(R.id.button_airplane);
        btn_airplane.setOnClickListener(mClickListener);


    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            TextView textView = (TextView) findViewById(R.id.text_View);

            if(v.getId() == R.id.button_car) {
                textView.setText("자동차");
            }
            else if (v.getId() == R.id.button_airplane)
                    textView.setText("비행기");
            }


    };


    public void onClick(View v){

        TextView textView = (TextView) findViewById(R.id.text_View);

        if(v.getId() == R.id.button_train) {
            textView.setText("기차");
        }

    }









}