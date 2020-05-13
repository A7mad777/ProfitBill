package com.example.future.currentselling.Data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.content.ClipData;

import java.util.List;

@Dao
public interface ItemDao {
    @Insert
    void insert(Item item);
    @Delete
    void delete(Item item);
    @Query("SELECT * FROM sell")
    List<Item>getItems();
}
