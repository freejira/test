package com.example.final_pro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class gacha extends AppCompatActivity {

    private ImageView img_gif;
    Button btn_gacha_one, btn_gacha_ten;
    ImageButton btn_back;
    TextView money;
    int[] database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gacha);

        database = getIntent().getIntArrayExtra("DATA_BASE");


        btn_gacha_one = findViewById(R.id.btn_one_gacha);
        btn_gacha_ten = findViewById(R.id.btn_ten_gacha);
        btn_back = findViewById(R.id.back);
        img_gif = findViewById(R.id.bakery_owner);
        money = findViewById(R.id.money);

        money.setText(" money: " + database[0]);


        Glide.with(this)
                .asGif()
                .load(R.raw.kitchu)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(img_gif);

        btn_gacha_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (database[0] >= 100) {
                    database[0] -= 100;
                    Intent intent = new Intent(gacha.this, gacha_get.class);
                    intent.putExtra("DATA_BASE", database);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btn_gacha_ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (database[0] >= 1000) {
                    database[0] -= 1000;
                    Intent intent = new Intent(gacha.this, gacha_get_ten.class);
                    intent.putExtra("DATA_BASE", database);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gacha.this, MainActivity.class);
                intent.putExtra("DATA_BASE", database);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}