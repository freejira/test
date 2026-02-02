package com.example.event_pro;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //View vw = new MyView(this);
        //setContentView(vw);



        View viw = new View(this);
        viw.setOnTouchListener(TouchListener);

        setContentView(viw);
    }

//touch event
    /*
        public class MyView extends View {

            public MyView(Context context) {

                super(context);
            }

            public boolean onTouchEvent(MotionEvent event) {

                super.onTouchEvent(event);

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    Toast.makeText(MainActivity.this, "touchdown event received", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Toast.makeText(MainActivity.this, "touchup event received", Toast.LENGTH_SHORT).show();
                    return true;
                }

                return false;

            }
        }*/

//EventListener

    public class TouchListenerClass implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v,MotionEvent event) {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {

                Toast.makeText(MainActivity.this, "touchlistener event received", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    }

    TouchListenerClass TouchListener = new TouchListenerClass();


}