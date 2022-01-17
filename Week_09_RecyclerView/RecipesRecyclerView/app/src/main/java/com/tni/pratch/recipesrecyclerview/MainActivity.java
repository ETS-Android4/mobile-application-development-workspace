package com.tni.pratch.recipesrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private LinkedList<Recipe> mRecipeList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private RecipeListAdapter mAdapter;
    public static final String EXTRA_REPLY = "com.tni.pratch.recipesrecyclerview.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecipeDb db = new RecipeDb(this);
        mRecipeList = db.getRecipe();

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new RecipeListAdapter(this, mRecipeList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}