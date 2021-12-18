package com.tni.pratch.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {
    private TextView mShowOrderSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        mShowOrderSelected = findViewById(R.id.text_order);

        String showOrderText = "Order: " + intent.getStringExtra(MainActivity.EXTRA_SELECTED);
        mShowOrderSelected.setText(showOrderText);
    }
}