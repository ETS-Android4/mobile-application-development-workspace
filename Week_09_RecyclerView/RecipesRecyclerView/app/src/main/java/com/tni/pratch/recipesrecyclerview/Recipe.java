package com.tni.pratch.recipesrecyclerview;

import android.graphics.drawable.Drawable;

public class Recipe {
    public String name;
    public Drawable image;
    public String intro;
    public String description;

    public Recipe(String name, Drawable image, String intro, String description) {
        this.name = name;
        this.image = image;
        this.intro = intro;
        this.description = description;
    }
}
