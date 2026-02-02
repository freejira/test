package com.example.final_pro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button btn_go_bake, btn_go_collection, btn_go_dungeon;
    ImageButton btn_setting;
    TextView money;
    int[] database;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = getIntent().getIntArrayExtra("DATA_BASE");

        if (database == null) {
            database = new int[11];  // 데이터가 없는 경우만 초기화
        }

        btn_go_bake = (Button) findViewById(R.id.btn_go_bake);
        btn_go_collection = (Button) findViewById(R.id.btn_go_collection);
        btn_go_dungeon = (Button) findViewById(R.id.btn_go_dungeon);
        btn_setting = (ImageButton) findViewById(R.id.btn_setting);
        money = findViewById(R.id.money);

        money.setText(" money: " + database[0]);

        btn_go_bake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, gacha.class);

                intent.putExtra("DATA_BASE", database);

                startActivity(intent);
                finish();

            }
        });

        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, setting.class);
                intent.putExtra("DATA_BASE", database);
                startActivity(intent);
            }
        });


        btn_go_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, colection.class);
                intent.putExtra("DATA_BASE", database);
                startActivity(intent);

            }
        });


        btn_go_dungeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, dungeon.class);
                intent.putExtra("DATA_BASE", database);

                startActivity(intent);

            }
        });

    }
}