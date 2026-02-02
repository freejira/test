package com.example.final_pro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class setting extends AppCompatActivity {

    ImageButton btn_back;
    Button btn_save, btn_load;

    int[] database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        Intent inIntent = getIntent();
        database = getIntent().getIntArrayExtra("DATA_BASE");

        btn_back = findViewById(R.id.back);
        btn_save = findViewById(R.id.btn_save);
        btn_load = findViewById(R.id.btn_load);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting.this, MainActivity.class);
                intent.putExtra("DATA_BASE", database);
                startActivity(intent);
                finish();
            }
        });


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = openFileOutput("local_save.txt", Context.MODE_PRIVATE);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < database.length; i++) {
                        sb.append(database[i]);
                        if (i < database.length - 1) sb.append(",");
                    }
                    outFs.write(sb.toString().getBytes());
                    outFs.close();

                    Toast.makeText(getApplicationContext(), "진행 사항 저장됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "저장 중 오류 발생", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream inFs = openFileInput("local_save.txt");
                    byte[] txt = new byte[100];
                    int readBytes = inFs.read(txt);
                    inFs.close();

                    if (readBytes > 0) {
                        String dataStr = new String(txt, 0, readBytes);
                        String[] values = dataStr.trim().split(",");
                        database = new int[values.length];
                        for (int i = 0; i < values.length; i++) {
                            database[i] = Integer.parseInt(values[i].trim());
                        }
                        Toast.makeText(getApplicationContext(), "진행 사항 불러오기 성공", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "파일 읽기 실패", Toast.LENGTH_SHORT).show();
                    }

                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "파일 읽기 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}