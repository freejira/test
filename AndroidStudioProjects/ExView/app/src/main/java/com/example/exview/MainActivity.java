package com.example.exview;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button Btn_add, Btn_sub, Btn_mul, Btn_div;
    TextView Text_result;
    String num1, num2;
    Integer result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("초간단 계산기");


        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        Btn_add = (Button) findViewById(R.id.Btn_add);
        Btn_sub = (Button) findViewById(R.id.Btn_sub);
        Btn_mul = (Button) findViewById(R.id.Btn_mul);
        Btn_div = (Button) findViewById(R.id.Btn_div);

        Text_result = (TextView) findViewById(R.id.Text_result);



        Btn_add.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);

                Text_result.setText("계산 결과 : " + result.toString());

                return false;
            }
        });

        Btn_sub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);

                Text_result.setText("계산 결과 : " + result.toString());

                return false;
            }
        });

        Btn_mul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);

                Text_result.setText("계산 결과 : " + result.toString());

                return false;
            }
        });

        Btn_div.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);

                Text_result.setText("계산 결과 : " + result.toString());

                return false;
            }
        });




    }
}

