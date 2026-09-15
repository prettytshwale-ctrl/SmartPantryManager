package com.example.smartpantrymanager;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class RecipeDetailActivity extends AppCompatActivity {

    private RecipeDao recipeDao;
    private TextView txtRecipeName, txtIngredients, txtSteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        txtRecipeName = findViewById(R.id.txtRecipeName);
        txtIngredients = findViewById(R.id.txtIngredients);
        txtSteps = findViewById(R.id.txtSteps);

        // Get recipe ID passed from SuggestedRecipesActivity
        int recipeId = getIntent().getIntExtra("RECIPE_ID", -1);

        // Initialize DB
        PantryDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                PantryDatabase.class,
                "pantry_db"
        ).allowMainThreadQueries().build();

        recipeDao = db.recipeDao();

        // Fetch recipe by ID
        Recipe recipe = null;
        for (Recipe r : recipeDao.getAllRecipes()) {
            if (r.getId() == recipeId) {
                recipe = r;
                break;
            }
        }

        if (recipe != null) {
            txtRecipeName.setText(recipe.getName());
            txtIngredients.setText("Ingredients:\n" + String.join(", ", recipe.getIngredients()));
            txtSteps.setText("Steps:\n" + recipe.getSteps());
        }
    }
}
