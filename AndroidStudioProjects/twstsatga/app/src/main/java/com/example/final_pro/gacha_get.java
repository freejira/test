package com.example.final_pro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.Random;

public class gacha_get extends AppCompatActivity {

    private ImageView img_gif;
    ImageButton btn_back;
    TextView tv_breadname;
    int[] database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gacha_get);

        btn_back = findViewById(R.id.back);
        img_gif = findViewById(R.id.gif_get_bread);
        tv_breadname = findViewById(R.id.tv_breadname);

        database = getIntent().getIntArrayExtra("DATA_BASE");


        final int[] gifResIds = {
                R.raw.kitchu, R.raw.croirang, R.raw.eggball, R.raw.froll, R.raw.pancake,
                R.raw.pupnut, R.raw.ramo, R.raw.sorang, R.raw.turtlebread, R.raw.whitebread
        };

        final String[] breadNames = {
                "kitchu", "croirang", "eggball", "froll",
                "pancake", "pupnut", "ramo", "sorang", "turtlebread", "whitebread"
        };

        int randomIndex = new Random().nextInt(gifResIds.length);
        int pickedGifResId = gifResIds[randomIndex];

        database[1 + randomIndex]++;

        Glide.with(this)
                .asGif()
                .load(pickedGifResId)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(img_gif);

        tv_breadname.setText(breadNames[randomIndex]);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gacha_get.this, gacha.class);
                intent.putExtra("DATA_BASE", database);
                startActivity(intent);
                finish();
            }
        });
    }
}