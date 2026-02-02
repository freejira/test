package com.example.final_pro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.Random;

public class gacha_get_ten extends AppCompatActivity {

    ImageButton btn_back;
    ImageView im_1, im_2, im_3, im_4, im_5;
    int[] database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gacha_get_ten);

        btn_back = findViewById(R.id.back);
        im_1 = findViewById(R.id.im_1);
        im_2 = findViewById(R.id.im_2);
        im_3 = findViewById(R.id.im_3);
        im_4 = findViewById(R.id.im_4);
        im_5 = findViewById(R.id.im_5);

        database = getIntent().getIntArrayExtra("DATA_BASE");


        final int[] gifResIds = {
                R.raw.kitchu, R.raw.croirang, R.raw.eggball, R.raw.froll, R.raw.pancake,
                R.raw.pupnut, R.raw.ramo, R.raw.sorang, R.raw.turtlebread, R.raw.whitebread
        };

        Random random = new Random();

        int idx1 = random.nextInt(gifResIds.length);
        int idx2 = random.nextInt(gifResIds.length);
        int idx3 = random.nextInt(gifResIds.length);
        int idx4 = random.nextInt(gifResIds.length);
        int idx5 = random.nextInt(gifResIds.length);

        database[1 + idx1]++;
        database[1 + idx2]++;
        database[1 + idx3]++;
        database[1 + idx4]++;
        database[1 + idx5]++;

        Glide.with(this).asGif().load(gifResIds[idx1]).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(im_1);
        Glide.with(this).asGif().load(gifResIds[idx2]).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(im_2);
        Glide.with(this).asGif().load(gifResIds[idx3]).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(im_3);
        Glide.with(this).asGif().load(gifResIds[idx4]).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(im_4);
        Glide.with(this).asGif().load(gifResIds[idx5]).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(im_5);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gacha_get_ten.this, gacha.class);
                intent.putExtra("DATA_BASE", database);
                startActivity(intent);
                finish();
            }
        });
    }
}