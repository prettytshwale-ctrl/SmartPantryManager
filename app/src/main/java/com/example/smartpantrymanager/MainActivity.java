package com.example.smartpantrymanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private PantryDatabase db;
    private RecipeDao recipeDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Room database
        db = Room.databaseBuilder(
                getApplicationContext(),
                PantryDatabase.class,
                "pantry_db"
        ).allowMainThreadQueries().build();

        recipeDao = db.recipeDao();

        // Seed recipes only once (if table is empty)
        if (recipeDao.getAllRecipes().isEmpty()) {
            seedRecipes(recipeDao);
        }

        // Pantry button navigation
        Button btnPantry = findViewById(R.id.btnPantry);
        btnPantry.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PantryListActivity.class);
            startActivity(intent);
        });

        Button btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });


        // Suggested Recipes button navigation
        Button btnSuggested = findViewById(R.id.btnSuggested);
        if (btnSuggested != null) {
            btnSuggested.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, SuggestedRecipesActivity.class);
                startActivity(intent);
            });
        }
    }

    // ✅ Method to seed recipes into the database
    private void seedRecipes(RecipeDao recipeDao) {
        Recipe spaghetti = new Recipe();
        spaghetti.setName("Spaghetti Bolognese");
        spaghetti.setIngredients(Arrays.asList("spaghetti", "minced beef", "tomato", "onion"));
        spaghetti.setSteps("Boil spaghetti. Cook beef with tomato and onion. Mix together.");
        recipeDao.insertRecipe(spaghetti);

        Recipe salad = new Recipe();
        salad.setName("Simple Salad");
        salad.setIngredients(Arrays.asList("lettuce", "tomato", "cucumber"));
        salad.setSteps("Chop vegetables. Mix together. Serve fresh.");
        recipeDao.insertRecipe(salad);

        Recipe omelette = new Recipe();
        omelette.setName("Cheese Omelette");
        omelette.setIngredients(Arrays.asList("eggs", "cheese", "milk"));
        omelette.setSteps("Beat eggs with milk. Fry in pan. Add cheese and fold.");
        recipeDao.insertRecipe(omelette);

        Recipe pancakes = new Recipe();
        pancakes.setName("Pancakes");
        pancakes.setIngredients(Arrays.asList("flour", "milk", "eggs"));
        pancakes.setSteps("Mix flour, milk, and eggs. Fry batter in pan. Serve with syrup.");
        recipeDao.insertRecipe(pancakes);

        Recipe friedRice = new Recipe();
        friedRice.setName("Fried Rice");
        friedRice.setIngredients(Arrays.asList("rice", "egg", "carrot", "peas", "soy sauce"));
        friedRice.setSteps("Cook rice. Fry vegetables and egg. Mix with rice and soy sauce.");
        recipeDao.insertRecipe(friedRice);

        Recipe sandwich = new Recipe();
        sandwich.setName("Ham Sandwich");
        sandwich.setIngredients(Arrays.asList("bread", "ham", "cheese", "lettuce"));
        sandwich.setSteps("Layer ham, cheese, and lettuce between bread slices.");
        recipeDao.insertRecipe(sandwich);

        Recipe soup = new Recipe();
        soup.setName("Tomato Soup");
        soup.setIngredients(Arrays.asList("tomato", "onion", "garlic", "salt"));
        soup.setSteps("Cook tomatoes with onion and garlic. Blend until smooth.");
        recipeDao.insertRecipe(soup);

        Recipe curry = new Recipe();
        curry.setName("Chicken Curry");
        curry.setIngredients(Arrays.asList("chicken", "onion", "tomato", "curry powder"));
        curry.setSteps("Cook chicken with onion and tomato. Add curry powder and simmer.");
        recipeDao.insertRecipe(curry);

        Recipe stirFry = new Recipe();
        stirFry.setName("Vegetable Stir Fry");
        stirFry.setIngredients(Arrays.asList("broccoli", "carrot", "bell pepper", "soy sauce"));
        stirFry.setSteps("Stir fry vegetables in pan. Add soy sauce and serve.");
        recipeDao.insertRecipe(stirFry);

        Recipe burger = new Recipe();
        burger.setName("Beef Burger");
        burger.setIngredients(Arrays.asList("beef patty", "bun", "lettuce", "tomato"));
        burger.setSteps("Cook beef patty. Assemble with bun, lettuce, and tomato.");
        recipeDao.insertRecipe(burger);

        Recipe pizza = new Recipe();
        pizza.setName("Margherita Pizza");
        pizza.setIngredients(Arrays.asList("pizza base", "tomato sauce", "cheese", "basil"));
        pizza.setSteps("Spread sauce on base. Add cheese and basil. Bake until golden.");
        recipeDao.insertRecipe(pizza);

        Recipe stew = new Recipe();
        stew.setName("Beef Stew");
        stew.setIngredients(Arrays.asList("beef", "potato", "carrot", "onion"));
        stew.setSteps("Cook beef with vegetables. Simmer until tender.");
        recipeDao.insertRecipe(stew);

        Recipe scrambledEggs = new Recipe();
        scrambledEggs.setName("Scrambled Eggs");
        scrambledEggs.setIngredients(Arrays.asList("eggs", "milk", "butter"));
        scrambledEggs.setSteps("Beat eggs with milk. Cook in butter until fluffy.");
        recipeDao.insertRecipe(scrambledEggs);
