package com.example.tesminepoulose_comp304_sec001_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.lstView);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            if(position==0) {
                Intent intent = new Intent(getApplicationContext(), CanvasActivity.class);
                startActivity(intent);
            }
            else if(position==1)
            {
                Intent intent = new Intent(getApplicationContext(), FramedActivity.class);
                startActivity(intent);
            }
        });
    }
}