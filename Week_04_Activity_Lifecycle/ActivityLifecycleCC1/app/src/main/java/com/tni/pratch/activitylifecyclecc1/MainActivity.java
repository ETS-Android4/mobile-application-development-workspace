package com.tni.pratch.activitylifecyclecc1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;

    private static final TextView[] mItemsView = new TextView[10];
    private ArrayList<String> itemsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mItemsView[0] = findViewById(R.id.item1);
        mItemsView[1] = findViewById(R.id.item2);
        mItemsView[2] = findViewById(R.id.item3);
        mItemsView[3] = findViewById(R.id.item4);
        mItemsView[4] = findViewById(R.id.item5);
        mItemsView[5] = findViewById(R.id.item6);
        mItemsView[6] = findViewById(R.id.item7);
        mItemsView[7] = findViewById(R.id.item8);
        mItemsView[8] = findViewById(R.id.item9);
        mItemsView[9] = findViewById(R.id.item10);

        if (savedInstanceState != null) {
            itemsList = savedInstanceState.getStringArrayList("itemListStringArray");
            if (itemsList != null && itemsList.size() > 0) {
                for (int i = 0; i < itemsList.size(); i++) {
                    mItemsView[i].setText(itemsList.get(i));
                }
            }
        }
    }

    public void lunchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (itemsList.size() != 0) {
            outState.putStringArrayList("itemListStringArray", itemsList);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String item = data.getStringExtra(SecondActivity.EXTRA_ITEM);
                if (itemsList.size() < 10) {
                    itemsList.add(item);
                    for (int i = 0; i < itemsList.size(); i++) {
                        mItemsView[i].setText(itemsList.get(i));
                    }
                }
            }
        }
    }
}