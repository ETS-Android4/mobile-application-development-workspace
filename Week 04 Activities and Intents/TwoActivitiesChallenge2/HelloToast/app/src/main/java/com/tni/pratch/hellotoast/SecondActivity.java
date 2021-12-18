package com.tni.pratch.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mCurrentCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        mCurrentCount = findViewById(R.id.text_current_count);
        mCurrentCount.setText(intent.getStringExtra(MainActivity.EXTRA_COUNT));
    }
}