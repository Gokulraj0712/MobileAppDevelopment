package com.example.tesminepoulose_comp304sec001_lab2_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("before Moving to Menu");
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.openMusic);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MusicMenuPage.class);
                System.out.println("Moving to Menu");
                startActivity(intent);

            }
        });
    }
}