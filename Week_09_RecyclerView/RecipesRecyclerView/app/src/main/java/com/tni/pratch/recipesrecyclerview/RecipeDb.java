package com.tni.pratch.recipesrecyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.LinkedList;


public class RecipeDb {
    static LinkedList<Recipe> mRecipe;
    private Context context;

    public RecipeDb(Context con) {
        context = con;
        createDb();
    }

    public void createDb() {
        mRecipe = new LinkedList<>();
        Resources res = context.getResources();
        String[] mName = res.getStringArray(R.array.recipe_name);
        String[] mIntro = res.getStringArray(R.array.recipe_intro);
        String mDescription = res.getString(R.string.lorem);
        ArrayList<Drawable> mImage = new ArrayList<>();

        mImage.add(ResourcesCompat.getDrawable(res, R.drawable.chocolate_mint_bar, null));
        mImage.add(ResourcesCompat.getDrawable(res, R.drawable.blueberry_cupcakes, null));
        mImage.add(ResourcesCompat.getDrawable(res, R.drawable.fudge_brownies, null));
        mImage.add(ResourcesCompat.getDrawable(res, R.drawable.lemon_cake, null));
        mImage.add(ResourcesCompat.getDrawable(res, R.drawable.cobbler, null));
        mImage.add(ResourcesCompat.getDrawable(res, R.drawable.sheet_cake, null));
        mImage.add(ResourcesCompat.getDrawable(res, R.drawable.espresso_crinkles, null));
        mImage.add(ResourcesCompat.getDrawable(res, R.drawable.chocolate_cherry_cookies, null));
        mImage.add(ResourcesCompat.getDrawable(res, R.drawable.cheesecake, null));
        mImage.add(ResourcesCompat.getDrawable(res, R.drawable.tiramisu, null));
        mImage.add(ResourcesCompat.getDrawable(res, R.drawable.carrot_cake, null));
        mImage.add(ResourcesCompat.getDrawable(res, R.drawable.blueberry_ice_cream, null));

        for (int i = 0; i < mName.length; ++i) {
            mRecipe.addLast(new Recipe(mName[i], mImage.get(i), mIntro[i], mDescription));
        }

    }

    public LinkedList<Recipe> getRecipe() {
        return mRecipe;
    }
}
