package com.example.smartpantrymanager;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import java.util.ArrayList;
import java.util.List;

public class SuggestedRecipesActivity extends AppCompatActivity {

    private RecipeDao recipeDao;
    private PantryItemDao pantryItemDao;
    private TextView txtSuggestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested_recipes);

        txtSuggestions = findViewById(R.id.txtSuggestions);

        PantryDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                PantryDatabase.class,
                "pantry_db"
        ).allowMainThreadQueries().build();

        recipeDao = db.recipeDao();
        pantryItemDao = db.pantryItemDao();

        showSuggestedRecipes();
    }

    private void showSuggestedRecipes() {
        List<Recipe> allRecipes = recipeDao.getAllRecipes();
        List<PantryItem> pantryItems = pantryItemDao.getAllItems();

        List<String> pantryNames = new ArrayList<>();
        for (PantryItem item : pantryItems) {
            pantryNames.add(item.getName().toLowerCase());
        }

        List<Recipe> canMakeRecipes = new ArrayList<>();
        for (Recipe recipe : allRecipes) {
            boolean canMake = true;
            for (String ingredient : recipe.getIngredients()) {
                if (!pantryNames.contains(ingredient.toLowerCase())) {
                    canMake = false;
                    break;
                }
            }
            if (canMake) {
                canMakeRecipes.add(recipe);
            }
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerViewSuggested);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SuggestedRecipesAdapter(canMakeRecipes, this));

        if (canMakeRecipes.isEmpty()) {
            txtSuggestions.setText("No recipes match your pantry yet - add more ingredients.");
        } else {
            txtSuggestions.setText(""); // clear message if recipes exist
        }
    }
}

