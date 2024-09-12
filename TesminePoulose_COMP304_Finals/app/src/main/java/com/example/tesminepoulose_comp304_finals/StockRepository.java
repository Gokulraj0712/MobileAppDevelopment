package com.example.tesminepoulose_comp304_finals;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.ArrayList;
public class StockRepository {
    private final StockDao stockDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private MutableLiveData<Integer> deleteResult = new MutableLiveData<>();
    private LiveData<List<Stock>> stockList;

    //
    public StockRepository(Context context) {
        //create a database object
        AppDatabase db = AppDatabase.getInstance(context);
        //create an interface object
        stockDao = db.stockDao();
        //call interface method
        stockList = stockDao.getAllStocks();
    }

    // returns query results as LiveData object
    LiveData<List<Stock>> getAllPersons() {
        return stockList;
    }

    //inserts a person asynchronously
    public void insert(Stock stock) {
        insertAsync(stock);
    }

    //    //deletes a person asynchronously
    public void delete(Stock stock) { deleteAsync(stock); }

    // returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    //    // returns delete results as LiveData object
    public LiveData<Integer> getDeleteResult() {
        return deleteResult;
    }

//    // returns query results as LiveData object
//    LiveData<List<Person>> findPerson(String name) {
//        return personsList;
//    }

    //Insert and other queries must be done in AsyncTask or IT SHOULD NOT BE DONE ON MAIN UI THREAD
    private void insertAsync(final Stock stock) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    stockDao.insert(stock);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void deleteAsync(final Stock stock) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    stockDao.delete(stock);
                    deleteResult.postValue(1);
                } catch (Exception e) {
                    deleteResult.postValue(0);
                }
            }
        }).start();
    }

}

