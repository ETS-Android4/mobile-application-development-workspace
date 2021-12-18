package com.tni.pratch.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_COUNT = "com.tni.pratch.hellotoast.extra.COUNT";

    private int mCount = 0;
    private TextView mShowCount;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        intent = new Intent(this, SecondActivity.class);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    public void lunchSecondActivity(View view) {
        String mCurrentCount = mShowCount.getText().toString();
        intent.putExtra(EXTRA_COUNT, mCurrentCount);
        startActivity(intent);
    }
}