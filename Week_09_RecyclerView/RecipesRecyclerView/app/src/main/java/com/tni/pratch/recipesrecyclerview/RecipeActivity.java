package com.tni.pratch.recipesrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    private TextView mRecipeName, mRecipeDescription;
    private ImageView mRecipeImage;
    public String position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        mRecipeName = findViewById(R.id.recipe_name);
        mRecipeImage = findViewById(R.id.recipe_image);
        mRecipeDescription = findViewById(R.id.recipe_description);

        Intent intent = getIntent();
        position = intent.getStringExtra(MainActivity.EXTRA_REPLY);
        int pos = Integer.parseInt(position);
        setRecipeView(pos);

    }

    private void setRecipeView(int position) {
        Recipe recipe = RecipeDb.mRecipe.get(position);
        mRecipeName.setText(recipe.name);
        mRecipeImage.setImageDrawable(recipe.image);
        mRecipeDescription.setText(recipe.description);
    }
}