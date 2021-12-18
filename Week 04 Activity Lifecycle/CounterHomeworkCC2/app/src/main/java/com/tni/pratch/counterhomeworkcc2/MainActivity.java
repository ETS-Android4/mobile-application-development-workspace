package com.tni.pratch.counterhomeworkcc2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mShowCount;
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.count_textview);

        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt("current_count");
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    public void countUp(View view) {
        mCount++;
        mShowCount.setText(Integer.toString(mCount));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (Integer.parseInt(mShowCount.getText().toString()) != 0) {
            outState.putInt("current_count", mCount);
        }
    }
}