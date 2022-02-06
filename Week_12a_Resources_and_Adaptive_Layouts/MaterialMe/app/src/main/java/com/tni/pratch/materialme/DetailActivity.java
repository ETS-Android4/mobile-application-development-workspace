package com.tni.pratch.materialme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Initialize the views.
        TextView sportsTitle = findViewById(R.id.titleDetail);
        ImageView sportsImage = findViewById(R.id.sportsImageDetail);
        TextView sportsDetail = findViewById(R.id.subTitleDetail);

//        // Set the text from the Intent extra.
//        sportsTitle.setText(getIntent().getStringExtra("title"));
//
//        // Load the image using the Glide library and the Intent extra.
//        Glide.with(this).load(getIntent().getIntExtra("image_resource",0))
//                .into(sportsImage);

        Sport selectedSport = getIntent().getParcelableExtra("selectedSport");
        // Set the text from the Intent extra.
        sportsTitle.setText(selectedSport.getTitle());

        // Load the image using the Glide library and the Intent extra.
        Glide.with(this).load(selectedSport.getImageResource())
                .into(sportsImage);

        sportsDetail.setText(selectedSport.getDetails());
    }
}