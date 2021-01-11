package com.example.respies;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import com.example.respies.adapters.OnRecipeListener;
import com.example.respies.adapters.RecipeRecyclerAdapter;
import com.example.respies.methods.Recipe;
import com.example.respies.viewmodel.RecipeListViewModel;
import java.util.List;

public class RecipeListActivity extends BaseActivity implements OnRecipeListener {
    private RecipeListViewModel mrecipeListViewModel;
    private static final String TAG = "RecipeListActivity";
    private RecyclerView mRecyclerView;
    private RecipeRecyclerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipelist);
        mRecyclerView = findViewById(R.id.recipe_list);
        mrecipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel.class);
                initRecyclerView();
                subscribeObserver();
                testRetrofitRequest();
            }


        private void subscribeObserver(){
        mrecipeListViewModel.getRecipe().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
            if (recipes != null){
                mAdapter.setRecipes(recipes);
                for (Recipe recipe : recipes){
                    Log.d(TAG,"response" + recipe.getTitle());
                }
            }
            }
        });
        }

    private void initRecyclerView(){
        mAdapter = new RecipeRecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void searchReipeApi(String query,int pagenumber){
        mrecipeListViewModel.searchReipeApi(query,pagenumber);
    }
        private void testRetrofitRequest(){
            searchReipeApi("chicken breast",1);
        }

    @Override
    public void onRecipeClick(int position) {

    }

    @Override
    public void onCategory(String category) {

    }
}
