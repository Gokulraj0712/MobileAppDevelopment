package com.example.tesminepoulose_comp304_finals;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
public class StockViewModel extends AndroidViewModel {
    // calling repository tasks and
    // sending the results to the Activity
    private StockRepository stockRepository;

    private LiveData<Integer> insertResult;
    private LiveData<Integer> deleteResult;
    private LiveData<List<Stock>> allStocks;
    //

    public StockViewModel(@NonNull Application application) {
        super(application);
        stockRepository = new StockRepository(application);
        insertResult = stockRepository.getInsertResult();
        deleteResult = stockRepository.getDeleteResult();
        allStocks = stockRepository.getAllPersons();
    }
    //calls repository to insert a stock
    public void insert(Stock stock) {
        stockRepository.insert(stock);
    }

    //calls repository to delete a stock
    public void delete(Stock stock) { stockRepository.delete(stock); }

    //gets insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    //gets insert results as LiveData object
    public LiveData<Integer> getDeleteResult() {
        return deleteResult;
    }

    //returns query results as live data object
    LiveData<List<Stock>> getAllStocks() { return allStocks; }

}