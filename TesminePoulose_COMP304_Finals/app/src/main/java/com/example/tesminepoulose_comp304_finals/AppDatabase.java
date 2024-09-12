package com.example.tesminepoulose_comp304_finals;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
//Room database class
@Database(entities = {Stock.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    //
    private static volatile AppDatabase INSTANCE;
    private static final String DATABASE_NAME = "StockDB";
    public abstract StockDao stockDao();

    //Singleton Pattern to have one instance of DB
    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            //Create database object
            INSTANCE = Room.databaseBuilder(context,
                    AppDatabase.class, DATABASE_NAME).build();
        }
        return INSTANCE;
    }
}
