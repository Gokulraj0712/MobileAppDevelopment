package com.example.tesminepoulose_comp304sec001_lab2_ex1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerInfo extends AppCompatActivity {

    //preferences data variable
    SharedPreferences myPref;
    //variable to modify preference data
    SharedPreferences.Editor prefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_activity);
        myPref = getSharedPreferences("info", MODE_PRIVATE);
        String mode = myPref.getString("mode", "");
        TextView text= (TextView) findViewById(R.id.text);
        TextView number=(TextView) findViewById(R.id.number);
        TextView cvv=(TextView) findViewById(R.id.cvv);
        TextView expiry=(TextView) findViewById(R.id.expiry);
        text.setText("Customer Information ");
        Log.d("mode",mode);
        if(mode.contentEquals("Cash")){
            Log.d("entered",mode);
            number.setVisibility(View.INVISIBLE);
            cvv.setVisibility(View.INVISIBLE);
            expiry.setVisibility(View.INVISIBLE);
        }
        prefEditor= myPref.edit();
    }

    public void onClickSubmit(View view) {
        EditText number=(EditText) findViewById(R.id.number);
        EditText cvv=(EditText) findViewById(R.id.cvv);
        EditText expiry=(EditText) findViewById(R.id.expiry);
        EditText fullName=(EditText) findViewById(R.id.fullName);
        EditText question1=(EditText) findViewById(R.id.question1);
        EditText question2=(EditText) findViewById(R.id.question2);
        EditText question3=(EditText) findViewById(R.id.question3);
        TextView error=(TextView) findViewById(R.id.error);
        String mode = myPref.getString("mode", "");

        if(mode.contentEquals("Cash")){
            if (fullName.length() > 0 && question1.length() > 0 && question2.length() > 0 && question3.length() > 0) {
                Intent intent = new Intent(CustomerInfo.this, PaymentSummary.class);
                startActivity(intent);
            }
            else {
                error.setText("Please enter all the fields");

            }
        }
        else{
            if (number.length() > 0 && cvv.length() > 0 && expiry.length() > 0 && fullName.length() > 0 && question1.length() > 0 && question2.length() > 0 && question3.length() > 0) {
                if (number.length() == 16) {
                    if (cvv.length() == 3) {
                        prefEditor.putString("fullName", fullName.getText().toString());
                        prefEditor.commit();
                        Intent intent = new Intent(CustomerInfo.this, PaymentSummary.class);
                        startActivity(intent);
                    } else {
                        error.setText("Please enter a valid 3 digit CVV number");
                    }
                } else {
                    error.setText("Please enter a valid 16 digit card number without spaces");
                }
            } else {
                error.setText("Please enter all the fields");
            }
        }
    }
}