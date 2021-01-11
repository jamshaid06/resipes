package com.example.respies.request.responses;

import com.example.respies.methods.Recipe;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RecipeResponse {
    private Recipe recipe;
    @SerializedName("recipe")
    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return "RecipeResponse{" +
                "recipe=" + recipe +
                '}';
    }
}
