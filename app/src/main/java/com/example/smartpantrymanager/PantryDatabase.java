package com.example.smartpantrymanager;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {PantryItem.class, Recipe.class}, version = 1)
public abstract class PantryDatabase extends RoomDatabase {
    public abstract PantryItemDao pantryItemDao();
    public abstract RecipeDao recipeDao();
}

