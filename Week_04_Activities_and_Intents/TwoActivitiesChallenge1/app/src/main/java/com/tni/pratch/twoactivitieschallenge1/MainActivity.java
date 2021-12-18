package com.tni.pratch.twoactivitieschallenge1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String CHOICE = "com.tni.pratch.twoactivitieschallenge1.CHOICE";
    public static final String TITILE = "com.tni.pratch.twoactivitieschallenge1.TITLE";
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, SecondActivity.class);
    }

    public void lunchOne(View view) {
        intent.putExtra(CHOICE, "one");
        intent.putExtra(TITILE, "Text one");
        startActivity(intent);
    }

    public void lunchTwo(View view) {
        intent.putExtra(CHOICE, "two");
        intent.putExtra(TITILE, "Text two");
        startActivity(intent);
    }

    public void lunchThree(View view) {
        intent.putExtra(CHOICE, "three");
        intent.putExtra(TITILE, "Text three");
        startActivity(intent);
    }
}