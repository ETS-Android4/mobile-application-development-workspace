package com.tni.pratch.howfastareyou;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String CUR_SCORE = "current_score";
    // View members
    private TextView score_tv;
    private Button start_btn;
    private ProgressBar pb;
    private ImageView im1, im2, im3, im4, im5;

    // game members
    int cur_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize view
        score_tv = findViewById(R.id.score_textview);
        start_btn = findViewById(R.id.start_btn);
        pb = findViewById(R.id.progressBar);
        im1 = findViewById(R.id.imgV_1);
        im2 = findViewById(R.id.imgV_2);
        im3 = findViewById(R.id.imgV_3);
        im4 = findViewById(R.id.imgV_4);
        im5 = findViewById(R.id.imgV_5);

        // reset game initial value
        resetGame();

        // Restore current score
        if (savedInstanceState != null) {
            String cur_score_str = savedInstanceState.getString(CUR_SCORE);
            cur_score = Integer.parseInt(cur_score_str);
            score_tv.setText(cur_score_str);
        }

        start_btn.setOnClickListener(view -> {
            // toggle btn
            start_btn.setVisibility(View.INVISIBLE);

            // reset score
            cur_score = 0;
            score_tv.setText(R.string.zero);
            new startCountingTask(pb, start_btn, im1, im2, im3, im4, im5).execute();
        });

        // Set onclick to imgView
        im1.setOnClickListener(this::doWhatImgDo);
        im2.setOnClickListener(this::doWhatImgDo);
        im3.setOnClickListener(this::doWhatImgDo);
        im4.setOnClickListener(this::doWhatImgDo);
        im5.setOnClickListener(this::doWhatImgDo);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String cur_score_str = Integer.toString(cur_score);
        outState.putString(CUR_SCORE, cur_score_str);
    }

    private void resetGame() {
        // init reset score
        score_tv.setText(R.string.zero);

        // init set visible on image
        im1.setVisibility(View.INVISIBLE);
        im2.setVisibility(View.INVISIBLE);
        im3.setVisibility(View.INVISIBLE);
        im4.setVisibility(View.INVISIBLE);
        im5.setVisibility(View.INVISIBLE);
    }

    private void doWhatImgDo(View v) {
        v.setVisibility(View.INVISIBLE);
        // increment score count by 1
        cur_score++;
        String cur_score_str = Integer.toString(cur_score);
        score_tv.setText(cur_score_str);
    }
}