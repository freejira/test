package com.example.sampledelayed;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tv1;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        btn = (Button) findViewById(R.id.btn);
        tv1 = (TextView) findViewById(R.id.tv1);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
            }
        });

    }


    private void request(){

        String title = "원격 요청";
        String message = "데이터를 요청하시겠습니까?";
        String titleBtnY = "예";
        String titleBtnN = "아니오";

        AlertDialog dialog = makeRequestDialog(title, message, titleBtnY, titleBtnN);
        dialog.show();

        tv1.setText("대화상자 표시중...");
    }
    
    private AlertDialog makeRequestDialog(CharSequence title, CharSequence message, CharSequence titleBtnY, CharSequence titleBtnN){
        
        AlertDialog.Builder requestDialog = new AlertDialog.Builder(this);
        requestDialog.setTitle(title);
        requestDialog.setMessage(message);
        requestDialog.setPositiveButton(titleBtnY, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("5초 후에 결과 표시됨");
                
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tv1.setText("요청 만료됨");
                    }
                }, 5000);
            }
        });
        
        
        return requestDialog.create();
    }
}

