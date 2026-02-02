package com.example.touch;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView iv_smile;
    float screen_width, screen_height;
    float iv_width, iv_height;
    float x,y;
    float prev_x, prev_y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    iv_smile = (ImageView) findViewById(R.id.smile);

        Display display = getWindowManager().getDefaultDisplay();
        screen_height = display.getHeight();
        screen_width = display.getWidth();

        iv_smile.measure(iv_smile.getMeasuredWidth(), iv_smile.getMeasuredHeight());
        iv_height = iv_smile.getMeasuredHeight();
        iv_width = iv_smile.getMeasuredWidth();


        x = screen_width / 2 - iv_width / 2;
        y = screen_height / 2 - iv_height / 2;

        iv_smile.setX(x);
        iv_smile.setY(y);

        prev_x = x;
        prev_y = y;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

            case MotionEvent.ACTION_MOVE:

                x = event.getX() - iv_width / 2;
                y = event.getY() - iv_height / 2;


                ObjectAnimator smileX = ObjectAnimator.ofFloat(iv_smile, "translationX", prev_x, x);
                smileX.start();
                ObjectAnimator smileY = ObjectAnimator.ofFloat(iv_smile, "translationY", prev_y, y);
                smileY.start();

                prev_x = x;
                prev_y = y;

                //iv_smile.setX(x);
                //iv_smile.setY(y);


                break;



        }
        return false;
    }
}