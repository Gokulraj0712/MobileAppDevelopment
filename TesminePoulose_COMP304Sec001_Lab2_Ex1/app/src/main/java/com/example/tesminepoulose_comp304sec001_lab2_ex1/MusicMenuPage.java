package com.example.tesminepoulose_comp304sec001_lab2_ex1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MusicMenuPage extends AppCompatActivity {

    Button btnNext;
    RadioGroup SelectType;
    String radioValue = "";
    //preference data variable
    SharedPreferences myPreference;
    //variable to modify preference data
    SharedPreferences.Editor prefEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicmenu);
        setTitle("Select Type");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SelectType = findViewById(R.id.radiogrp);
        btnNext = findViewById(R.id.btnnext);


        SelectType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                                                  @Override
                                                  public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                      radioValue = ((RadioButton) findViewById(SelectType.getCheckedRadioButtonId())).getText().toString();

                                                      //Toast.makeText(getBaseContext(), gender, Toast.LENGTH_SHORT).show();
                                                  }
                                              }
        );
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioValue.equals("Rock")) {
                    Toast.makeText(getBaseContext(), "You Selected Rock!", Toast.LENGTH_LONG).show();
                    //instantiate the preference data variable
                    myPreference = getSharedPreferences("info", 0);
                    //prepare it for edit by creating and Edit object
                    prefEditor = myPreference.edit();
                    //store "set" in  a preference named "program"
                    prefEditor.putString("songType", "Rock");
                    //commit the transaction
                    prefEditor.commit();
                    //show SoftEngActivity
                    Intent vv = new Intent(MusicMenuPage.this, Pop.class);
                    vv.putExtra("key", "Rock");
                    startActivity(vv);

                } else if (radioValue.equals("Pop")) {
                    Toast.makeText(getBaseContext(), "You selected Pop!", Toast.LENGTH_LONG).show();
                    //instantiate the preference data variable
                    myPreference = getSharedPreferences("info", 0);
                    //prepare it for edit by creating and Edit object
                    prefEditor = myPreference.edit();
                    //store "set" in  a preference named "program"
                    prefEditor.putString("songType", "Pop");
                    //commit the transaction
                    prefEditor.commit();
                    //show SoftEngActivity
                    Intent vv = new Intent(MusicMenuPage.this, Rock.class);
                    vv.putExtra("key", "Pop");
                    startActivity(vv);


                }
                else if (radioValue.equals("Jazz")) {
                    Toast.makeText(getBaseContext(), "You selected Jazz!", Toast.LENGTH_LONG).show();
                    //instantiate the preference data variable
                    myPreference = getSharedPreferences("info", 0);
                    //prepare it for edit by creating and Edit object
                    prefEditor = myPreference.edit();
                    //store "set" in  a preference named "program"
                    prefEditor.putString("songType", "Jazz");
                    //commit the transaction
                    prefEditor.commit();
                    //show SoftEngActivity
                    Intent vv = new Intent(MusicMenuPage.this, Jazz.class);
                    vv.putExtra("key", "Jazz");
                    startActivity(vv);

                } else if (radioValue.equals("Classical")) {
                    Toast.makeText(getBaseContext(), "You selected Classical!", Toast.LENGTH_LONG).show();
                    //instantiate the preference data variable
                    myPreference = getSharedPreferences("info", 0);
                    //prepare it for edit by creating and Edit object
                    prefEditor = myPreference.edit();
                    //store "set" in  a preference named "program"
                    prefEditor.putString("songType", "Classical");
                    //commit the transaction
                    prefEditor.commit();
                    //show SoftEngActivity
                    Intent vv = new Intent(MusicMenuPage.this, Classical.class);
                    vv.putExtra("key", "Classical");
                    startActivity(vv);

                } else if (radioValue.equals("Hip-Hop")) {
                    Toast.makeText(getBaseContext(), "You selected Hiphop!", Toast.LENGTH_LONG).show();
                    //instantiate the preference data variable
                    myPreference = getSharedPreferences("info", 0);
                    //prepare it for edit by creating and Edit object
                    prefEditor = myPreference.edit();
                    //store "set" in  a preference named "program"
                    prefEditor.putString("songType", "Hiphop");
                    //commit the transaction
                    prefEditor.commit();
                    Intent vv = new Intent(MusicMenuPage.this, HipHop.class);
                    vv.putExtra("key", "Hip-Hop");
                    startActivity(vv);

                } else {
                    Toast.makeText(getBaseContext(), "Select Any One Option", Toast.LENGTH_SHORT).show();


                }
            }
        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}