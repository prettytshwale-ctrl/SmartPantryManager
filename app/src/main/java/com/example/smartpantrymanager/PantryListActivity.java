package com.example.smartpantrymanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import java.util.List;

public class PantryListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PantryAdapter adapter;
    private PantryItemDao pantryItemDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_list);

        recyclerView = findViewById(R.id.recyclerViewPantry);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize Room database
        PantryDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                PantryDatabase.class,
                "pantry_db"
        ).allowMainThreadQueries().build();

        pantryItemDao = db.pantryItemDao();

        // Fetch items from DB
        List<PantryItem> pantryItems = pantryItemDao.getAllItems();

        // Set adapter (with DAO)
        adapter = new PantryAdapter(pantryItems, pantryItemDao);
        recyclerView.setAdapter(adapter);

        // Wire Add Ingredient button
        Button btnAddIngredient = findViewById(R.id.btnAddIngredient);
        btnAddIngredient.setOnClickListener(v -> {
            Intent intent = new Intent(PantryListActivity.this, AddIngredientActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh list when coming back from AddIngredientActivity
        List<PantryItem> pantryItems = pantryItemDao.getAllItems();
        adapter = new PantryAdapter(pantryItems, pantryItemDao);
        recyclerView.setAdapter(adapter);
    }
}


