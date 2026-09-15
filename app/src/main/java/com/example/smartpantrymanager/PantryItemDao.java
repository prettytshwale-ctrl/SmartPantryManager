package com.example.smartpantrymanager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface PantryItemDao {
    @Insert
    long insertItem(PantryItem item);  // returns row ID

    @Query("SELECT * FROM pantry_items")
    List<PantryItem> getAllItems();

    @Update
    void updateItem(PantryItem item);

    @Delete
    void deleteItem(PantryItem item);
}


