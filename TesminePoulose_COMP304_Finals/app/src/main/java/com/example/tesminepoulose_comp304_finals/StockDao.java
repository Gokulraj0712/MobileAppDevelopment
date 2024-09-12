package com.example.tesminepoulose_comp304_finals;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

// this interface declares database functions
// and does the mapping of SQL queries to functions
    @Dao
    public interface StockDao {
        //
        @Insert
        void insert(Stock stock);


        //Monitoring Query Result Changes with Live Data
        @Query("select * from Stock order by stockId")
        LiveData<List<Stock>> getAllStocks();


        @Delete
        void delete(Stock stock);


}
