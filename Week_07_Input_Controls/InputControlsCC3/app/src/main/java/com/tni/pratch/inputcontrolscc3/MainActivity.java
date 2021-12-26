package com.tni.pratch.inputcontrolscc3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final CheckBox[] mCheckBoxLists = new CheckBox[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCheckBoxLists[0] = findViewById(R.id.checkBox_1);
        mCheckBoxLists[1] = findViewById(R.id.checkBox_2);
        mCheckBoxLists[2] = findViewById(R.id.checkBox_3);
        mCheckBoxLists[3] = findViewById(R.id.checkBox_4);
        mCheckBoxLists[4] = findViewById(R.id.checkBox_5);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void showToast(View view) {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < 5; ++i) {
            if (mCheckBoxLists[i].isChecked()) {
                message.append(mCheckBoxLists[i].getText().toString()).append(" ");
            }
        }
        if (message.length() != 0)
            displayToast("Topping: " + message.toString());
        else
            displayToast("No topping selected");
    }
}