package com.tni.pratch.howfastareyou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // View members
    private TextView score_tv;
    private Button start_btn, click_me_btn;
    private ProgressBar pb;

    // game members
    int cur_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize view
        score_tv = findViewById(R.id.score_textview);
        start_btn = findViewById(R.id.start_btn);
        click_me_btn = findViewById(R.id.click_me_btn);
        pb = findViewById(R.id.progressBar);

        // init reset score
        score_tv.setText(R.string.zero);

        start_btn.setOnClickListener(view -> {
            // reset score
            cur_score = 0;
            score_tv.setText(R.string.zero);
            new startCountingTask(pb).execute();
        });

        click_me_btn.setOnClickListener(view -> {
            // increment score count by 1
            cur_score++;
            String cur_score_str = Integer.toString(cur_score);
            score_tv.setText(cur_score_str);
        });
    }
}