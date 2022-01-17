package com.tni.pratch.recipesrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    private final LinkedList<Recipe> mRecipeList;
    private LayoutInflater mInflater;
    private Context mContext;
    public int mPosition;

    public RecipeListAdapter(Context context, LinkedList<Recipe> recipeList) {
        mInflater = LayoutInflater.from(context);
        mRecipeList = recipeList;
        mContext = context;
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView mRecipeName, mRecipeIntro;
        public final RecipeListAdapter mAdapter;

        public RecipeViewHolder(View itemView, RecipeListAdapter adapter) {
            super(itemView);
            mRecipeName = itemView.findViewById(R.id.recipe_list_name);
            mRecipeIntro = itemView.findViewById(R.id.recipe_list_intro);
            mAdapter = adapter;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mPosition = getAdapterPosition();
            Intent intent = new Intent(mContext, RecipeActivity.class);
            String pos = Integer.toString(mPosition);
            intent.putExtra(MainActivity.EXTRA_REPLY, pos);
            mContext.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipelist_item, parent, false);
        return new RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeViewHolder holder, int position) {
        // String mName = mRecipeList.get(position).name;
        // String mIntro = mRecipeList.get(position).intro;
        Recipe recipe = mRecipeList.get(position);
        holder.mRecipeName.setText(recipe.name);
        holder.mRecipeIntro.setText(recipe.intro);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }
}
