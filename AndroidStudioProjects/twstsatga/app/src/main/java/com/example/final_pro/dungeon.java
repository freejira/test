package com.example.final_pro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class dungeon extends AppCompatActivity {

    int[] database;
    ImageButton btn_back, btn_click;
    TextView money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dungeon);

        btn_back = findViewById(R.id.back);
        btn_click = findViewById(R.id.click);
        money = findViewById(R.id.money);

        database = getIntent().getIntArrayExtra("DATA_BASE");

        money.setText(" money: " + database[0]);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dungeon.this, MainActivity.class);
                intent.putExtra("DATA_BASE", database);
                startActivity(intent);
                finish();
            }
        });

        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            database[0] += 100;
            money.setText(" money: " + database[0]);

            }
        });

    }
}