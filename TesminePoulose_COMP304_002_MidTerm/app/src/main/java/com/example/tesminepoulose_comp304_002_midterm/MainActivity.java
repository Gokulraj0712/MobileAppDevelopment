package com.example.tesminepoulose_comp304_002_midterm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public Button button;
    public EditText name;
    public String getname;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonsave);
        name = (EditText) findViewById(R.id.PersonName);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getname=name.getText().toString();

                if (name.getText().toString().trim().length()>0)
                {
                    Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                    System.out.println("Moving to Player Page");
                    intent.putExtra("personname",getname);
                    startActivity(intent);

                }
                else
                    {
                        Toast.makeText(getApplicationContext(), "Incorrect username/password", Toast.LENGTH_SHORT).show();

                    }
            }
    });
    }
}