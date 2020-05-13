package com.example.future.currentselling.Data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Item.class},version = 1)
public abstract class MyApplicationDataBase extends RoomDatabase {
    public abstract ItemDao itemDao();
}
