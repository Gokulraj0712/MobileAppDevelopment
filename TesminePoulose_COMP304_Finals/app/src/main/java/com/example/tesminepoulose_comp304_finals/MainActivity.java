package com.example.tesminepoulose_comp304_finals;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StockViewModel stockViewModel;
    private Button btnInsert;
    private EditText editTextName;
    private  EditText editTextValue;
    private TextView textViewDisplay;
    private EditText editTextDeleteName;
    private Button btnDelete;
    Stock stock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  //
        textViewDisplay = findViewById(R.id.textViewDisplay);
        //
        stockViewModel = ViewModelProviders.of(this).get(StockViewModel.class);
        //
        stock = new Stock();
        //
        stockViewModel.getInsertResult().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer result) {
                if (result == 1) {
                    Toast.makeText(MainActivity.this, "Stock successfully saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error saving Stock", Toast.LENGTH_SHORT).show();
                }
            }
        });

        stockViewModel.getDeleteResult().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer result) {
                if (result == 1) {
                    Toast.makeText(MainActivity.this, "Stock Deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error deleting Stock", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //if the LiveData already has data it will delivered
        // to the observer
        stockViewModel.getAllStocks().observe(this, new Observer<List<Stock>>() {
            @Override
            public void onChanged(@Nullable List<Stock> result) {
                String output="";
                for(Stock stock : result) {
                    output+= stock.getStockname() +"\t" +stock.getStockvalue()+"\n";
                }
                textViewDisplay.setText(output);
            }
        });
        //
        btnInsert = findViewById(R.id.btnInsert);
        //Implement the event handler method
        btnInsert.setOnClickListener(v -> {
            editTextName = findViewById(R.id.editTextName);
            stock.setStockname(editTextName.getText().toString());
            editTextValue=findViewById(R.id.editTextValue);
            stock.setStockvalue(Integer.parseInt(String.valueOf(editTextValue.getText())));
            stockViewModel.insert(stock); // new code
        });

        btnDelete = findViewById(R.id.btnDelete);

        //Implement the event handler method
        btnDelete.setOnClickListener(v -> {
            editTextDeleteName = findViewById(R.id.editTextDeleteName);
            for(Stock p: stockViewModel.getAllStocks().getValue()){
                if(p.getStockname().equals(editTextDeleteName.getText().toString())){
                    stockViewModel.delete(p);
                }
            }
        });
    }
    //
    public void getList(View view)
    {
        stockViewModel.getAllStocks();
    }

}