package com.tni.pratch.levellistbattery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView batteryImg;
    private int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batteryImg = findViewById(R.id.battery_img);

        level = 0;
    }

    public void decreaseBattery(View view) {
        if (level > 0) {
            level--;
            batteryImg.setImageLevel(level);
        }
    }

    public void increaseBattery(View view) {
        if (level < 6) {
            level++;
            batteryImg.setImageLevel(level);
        }
    }
}