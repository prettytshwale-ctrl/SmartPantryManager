package com.example.smartpantrymanager;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import java.util.List;

@Entity
public class Recipe {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String steps;

    // Store ingredients as a list of strings
    @TypeConverters(StringListConverter.class)
    private List<String> ingredients;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSteps() { return steps; }
    public void setSteps(String steps) { this.steps = steps; }

    public List<String> getIngredients() { return ingredients; }
    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }
}
