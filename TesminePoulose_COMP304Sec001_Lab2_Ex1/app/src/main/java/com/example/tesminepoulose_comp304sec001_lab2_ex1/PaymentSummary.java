package com.example.tesminepoulose_comp304sec001_lab2_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class PaymentSummary extends AppCompatActivity {


    //preferences data variable
    SharedPreferences myPref;
    //variable to modify preference data
    SharedPreferences.Editor prefEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary_activity);
        TextView summary = (TextView) findViewById(R.id.summaryText);
        myPref = getSharedPreferences("info", MODE_PRIVATE);
        String mode = myPref.getString("mode", "");
        String songType = myPref.getString("songType", "");
        String fullName = myPref.getString("fullName", "");
        Integer price = myPref.getInt("price", 0);
        String selection = myPref.getString("radioSelected", "");
        summary.setText("Summary" + "\n" + "Song Type: " + songType +"\n"   + "Song: " + selection +"\n" +"Price: " + price +" CAD" +"\n"+ "Payment Mode: "+ mode);
    }

    public void onbtnClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);    }
}
