package com.example.final_pro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class colection extends AppCompatActivity implements View.OnClickListener {

    int[] database;

    int[] BTN_Name = {
            R.id.back,
            R.id.kitchu,
            R.id.croirang,
            R.id.eggball,
            R.id.froll,
            R.id.pancake,
            R.id.pupnut,
            R.id.ramo,
            R.id.sorang,
            R.id.turtlebread,
            R.id.whitebread
    };

    String[] characterNames = {
            "Kitchu", "Croirang", "Eggball", "Froll", "Pancake",
            "Pupnut", "Ramo", "Sorang", "Turtlebread", "Whitebread"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colection);

        database = getIntent().getIntArrayExtra("DATA_BASE");

        for (int id : BTN_Name) {
            ImageButton btn = findViewById(id);
            if (btn != null) {
                btn.setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.back) {
            Intent intent = new Intent(colection.this, MainActivity.class);
            intent.putExtra("DATA_BASE", database);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.kitchu) display_ownnum(0);
        else if (id == R.id.croirang) display_ownnum(1);
        else if (id == R.id.eggball) display_ownnum(2);
        else if (id == R.id.froll) display_ownnum(3);
        else if (id == R.id.pancake) display_ownnum(4);
        else if (id == R.id.pupnut) display_ownnum(5);
        else if (id == R.id.ramo) display_ownnum(6);
        else if (id == R.id.sorang) display_ownnum(7);
        else if (id == R.id.turtlebread) display_ownnum(8);
        else if (id == R.id.whitebread) display_ownnum(9);

    }

    private void display_ownnum(int i) {

        int count = database[i+1];
        String name = characterNames[i];

        Toast.makeText(this, name + " : " + count + "개 보유 중", Toast.LENGTH_SHORT).show();
    }
}

