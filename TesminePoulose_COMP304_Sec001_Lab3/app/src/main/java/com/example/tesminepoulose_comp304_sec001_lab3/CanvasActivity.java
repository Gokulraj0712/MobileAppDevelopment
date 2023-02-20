package com.example.tesminepoulose_comp304_sec001_lab3;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CanvasActivity extends AppCompatActivity {

    private ImageView reusableImageView;
    private TextView textView;
    //
    private int startx = 0;
    private int starty = 0;
    private int endx=0;
    private int endy=0;
    //
    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        Spinner spinner = findViewById(R.id.spinner1);
        final List<Integer> dataList = new ArrayList<Integer>();
        for(int i=10;i<100;i=i+5)
        {
            dataList.add(i);
        }
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, dataList);
        spinner.setAdapter(arrayAdapter);



        paint = new Paint();
        paint.setColor(Color.RED);
        //paint.setStrokeWidth(30);

        bitmap = Bitmap.createBitmap(getWindowManager()
                .getDefaultDisplay().getWidth(), getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE); //background
        //
        reusableImageView = findViewById(R.id.ImageViewForDrawing);
        reusableImageView.setImageBitmap(bitmap);
        reusableImageView.setVisibility(View.VISIBLE);


        canvas.drawPoint(1,1,paint);



        spinner.setOnItemSelectedListener(new  AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {

                paint.setStrokeWidth(dataList.get(i));

            }
            // If no option selected
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });

        textView = findViewById(R.id.help);
        textView.setText("Use Arrow Keys to draw ! ");

    }

    public void drawright(View view) {
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endx=endx+5;
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;
        //moveRect(canvas);
        reusableImageView.invalidate();
        textView.setText("X= "+endx+"  Y= "+ endy);
    }

    public void drawdown(View view) {
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endy=endy+5;
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;
        //moveRect(canvas);
        reusableImageView.invalidate();
        textView.setText("X= "+endx+"  Y= "+ endy);
    }

    public void drawleft(View view) {
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endx=endx-5;
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;
        //moveRect(canvas);
        reusableImageView.invalidate();
        textView.setText("X= "+endx+"  Y= "+ endy);
    }

    public void drawup(View view) {
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endy=endy-5;
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;
        //moveRect(canvas);
        reusableImageView.invalidate();
        textView.setText("X= "+endx+"  Y= "+ endy);
    }

    public void redline(View view) {

        paint.setColor(Color.RED);
    }

    public void cyan(View view) {
        paint.setColor(Color.CYAN);
    }

    public void yellowline(View view) {
        paint.setColor(Color.YELLOW);
    }

    public void clearall(View view) {
        canvas.drawColor(Color.rgb(95, 75, 92)); //background
        canvas.drawColor(Color.WHITE);
        startx = 0;
        starty = 0;
        endx = 0;
        endy = 0;
        textView.setText("Use Arrow Keys to draw ! ");

    }
}

