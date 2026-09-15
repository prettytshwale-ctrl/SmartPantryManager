package com.example.smartpantrymanager;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface RecipeDao {
    @Insert
    void insertRecipe(Recipe recipe);

    @Query("SELECT * FROM Recipe")
    List<Recipe> getAllRecipes();
}

