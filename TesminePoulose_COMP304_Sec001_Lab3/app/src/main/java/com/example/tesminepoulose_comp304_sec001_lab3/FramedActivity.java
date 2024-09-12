package com.example.tesminepoulose_comp304_sec001_lab3;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FramedActivity extends AppCompatActivity {

    AnimationDrawable mframeAnimation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framedanimation);

        final Button onButton = (Button) findViewById(R.id.ButtonStart);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });

        // Handle Stop Button
        final Button offButton = (Button) findViewById(R.id.ButtonStop);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();

            }
        });
    }

    private void startAnimation()
    {

        ImageView img = (ImageView)findViewById(R.id.ImageView_Boy);

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.pic1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.pic2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.pic3);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.pic4);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.pic5);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.pic6);

        // Get the background, which has been compiled to an AnimationDrawable object.
        int reasonableDuration = 250;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);
        mframeAnimation.addFrame(frame3, reasonableDuration);
        mframeAnimation.addFrame(frame4, reasonableDuration);
        mframeAnimation.addFrame(frame5, reasonableDuration);
        mframeAnimation.addFrame(frame6, reasonableDuration);
        mframeAnimation.addFrame(frame6, reasonableDuration);
        mframeAnimation.addFrame(frame6, reasonableDuration);

        img.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }
    private void stopAnimation()
    {
        mframeAnimation.setVisible(false,false);
        mframeAnimation.stop();



    }



}
