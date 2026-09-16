package com.example.smartpantrymanager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class AddIngredientActivity extends AppCompatActivity {

    private EditText edtName, edtQuantity, edtUnit, edtExpiry;
    private PantryItemDao pantryItemDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredient);

        // Initialize Room database
        PantryDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                PantryDatabase.class,
                "pantry_db"
        ).allowMainThreadQueries().build();

        pantryItemDao = db.pantryItemDao();

        // Wire up UI
        edtName = findViewById(R.id.edtName);
        edtQuantity = findViewById(R.id.edtQuantity);
        edtUnit = findViewById(R.id.edtUnit);
        edtExpiry = findViewById(R.id.edtExpiry);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            String unit = edtUnit.getText().toString().trim();
            String expiry = edtExpiry.getText().toString().trim();
            double quantity = 0;

            try {
                quantity = Double.parseDouble(edtQuantity.getText().toString().trim());
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Enter a valid quantity", Toast.LENGTH_SHORT).show();
                return;
            }

            if (name.isEmpty() || unit.isEmpty() || expiry.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            PantryItem item = new PantryItem(name, quantity, unit, expiry);
            pantryItemDao.insertItem(item);

            Toast.makeText(this, "Item added!", Toast.LENGTH_SHORT).show();
            finish(); // go back to PantryListActivity
        });
    }
}

