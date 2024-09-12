package com.example.tesminepoulose_comp304sec001_lab2_ex1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class Song_checkout extends AppCompatActivity {

    String selection;
    //preferences data variable
    SharedPreferences myPref;
    //variable to modify preference data
    SharedPreferences.Editor prefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_songs_activity);
        myPref = getSharedPreferences("info", MODE_PRIVATE);
        String songType = myPref.getString("songType", "");
        Set<String> selected = myPref.getStringSet("selected", new HashSet<String>());
        Integer size = myPref.getInt("size", 0);
        selection = myPref.getString("radioSelection", "");
        TextView textSelected = (TextView) findViewById(R.id.songType);
        textSelected.setText("Selected Songs to Buy :" + "\n");
        String[] selectedArray = selected.toArray(new String[selected.size()]);
        RadioGroup radioGroup= (RadioGroup) findViewById(R.id.radioGroup);
        RadioGroup.LayoutParams rglp;

        for(int i=0;i<size;i++){
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(""+ selectedArray[i].replace("["," ").replace("]"," ").trim());
            radioButton.setId(View.generateViewId());
            rglp= new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            radioGroup.addView(radioButton, rglp);
        }
        prefEditor= myPref.edit();
    }

    public void onClickCheckout(View view) {
        RadioGroup radioGroup= (RadioGroup) findViewById(R.id.radioGroup);
        TextView error=(TextView) findViewById(R.id.error);
        if(radioGroup.getCheckedRadioButtonId()!=-1){
            int id= radioGroup.getCheckedRadioButtonId();
            View radioButton = radioGroup.findViewById(id);
            int radioId = radioGroup.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) radioGroup.getChildAt(radioId);
            selection = (String) btn.getText();
            prefEditor.putString("radioSelected",selection);
            selection = selection.replaceAll("[^\\d]", " ");
            selection = selection.trim();
            selection = selection.replaceAll(" +", " ");
            int price = Integer.parseInt(selection);
            prefEditor.putInt("price",price);
            prefEditor.commit();
            Intent intent = new Intent(this, Payment.class);
            startActivity(intent);
        }
        else{
            error.setText("Choose one");
        }
    }
}


