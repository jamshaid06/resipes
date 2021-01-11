package com.example.respies.viewmodel;


import com.example.respies.methods.Recipe;
import com.example.respies.repositories.RecipeRepository;
import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class RecipeListViewModel extends ViewModel {
    private RecipeRepository mRecipes;
    public RecipeListViewModel(){
        mRecipes = RecipeRepository.getInstance();
    }
    public LiveData<List<Recipe>> getRecipe (){
        return mRecipes.getRecipes();
    }
    public void searchReipeApi(String query,int pagenumber){
        mRecipes.searchRecipesApi(query,pagenumber);
    }
}
