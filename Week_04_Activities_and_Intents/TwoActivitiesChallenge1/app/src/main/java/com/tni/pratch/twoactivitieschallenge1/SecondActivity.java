package com.tni.pratch.twoactivitieschallenge1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mHeaderText;
    private TextView mScrollText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        mHeaderText = findViewById(R.id.text_header);
        mScrollText = findViewById(R.id.scrollText);

        mHeaderText.setText(intent.getStringExtra(MainActivity.TITILE));
        switch (intent.getStringExtra(MainActivity.CHOICE)) {
            case "one":
                mScrollText.setText(R.string.article_one);
                break;
            case "two":
                mScrollText.setText(R.string.article_two);
                break;
            case "three":
                mScrollText.setText(R.string.article_three);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + intent.getStringExtra(MainActivity.CHOICE));
        }
    }
}