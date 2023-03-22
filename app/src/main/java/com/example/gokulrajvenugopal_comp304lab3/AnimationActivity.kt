package com.example.gokulrajvenugopal_comp304lab3


import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


/*
Student Name: Gokulraj Venugopal
Student ID: 301202722
 */
class AnimationActivity : AppCompatActivity() {


    private lateinit var earth: ImageView
    private lateinit var circularTranslateAnim: Animation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solar)

        earth = findViewById(R.id.earthImageView)
        var sun = findViewById<ImageView>(R.id.sunImageView)

        circularTranslateAnim = AnimationUtils.loadAnimation(this, R.anim.circular_translate)

        // Set the pivot point for the Earth image to the center of the Sun image
        earth.pivotX = sun.width / 2.toFloat()
        earth.pivotY = sun.height / 2.toFloat()

        earth.startAnimation(circularTranslateAnim)

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}