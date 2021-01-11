package com.example.respies.request;

import com.example.respies.request.responses.RecipeResponse;
import com.example.respies.request.responses.RecipeSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApi {
  @GET("/api/post/all")
  Call<RecipeSearchResponse> searchRecipe(
            @Query("q") String querry,
            @Query("page") String page
  );
  @GET("api/get")
    Call<RecipeResponse> getRecipe(
            @Query("rId") String recipe_id
  );

}