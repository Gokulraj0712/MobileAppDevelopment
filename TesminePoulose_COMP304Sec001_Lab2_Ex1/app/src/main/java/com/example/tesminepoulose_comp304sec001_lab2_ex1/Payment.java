package com.example.tesminepoulose_comp304sec001_lab2_ex1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Payment extends AppCompatActivity {

    //preferences data variable
    SharedPreferences myPref;
    //variable to modify preference data
    SharedPreferences.Editor prefEditor;
    String checked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_method_activity);
        myPref = getSharedPreferences("info", MODE_PRIVATE);
        Integer price = myPref.getInt("price", 0);
        TextView modes=(TextView) findViewById(R.id.mode);
        modes.setText("Amount            " + " \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t "+ price +" CAD");
        prefEditor= myPref.edit();
    }

    public void onClickPay(View view) {
        RadioGroup radioGroup= (RadioGroup) findViewById(R.id.RadioGroup01);
        TextView error=(TextView) findViewById(R.id.error);
        if(radioGroup.getCheckedRadioButtonId()!=-1){
            int id= radioGroup.getCheckedRadioButtonId();
            View radioButton = radioGroup.findViewById(id);
            int radioId = radioGroup.indexOfChild(radioButton);
            if(radioId!=-1) {
                RadioButton btn = (RadioButton) radioGroup.getChildAt(radioId);
                checked = (String) btn.getText();
                prefEditor.putString("mode",checked);
                prefEditor.commit();
                Intent intent = new Intent(this, CustomerInfo.class);
                startActivity(intent);
            }
        }
        else {
            error.setText("Choose one mode of payment");
        }
    }
}



