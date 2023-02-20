package com.example.gokulrajvenugopa_comp304lab1_ex1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setTitle("My First App");

        val textView = findViewById<TextView>(R.id.text)

        val data = intent.getStringExtra("DATA", )
        textView.text=data
    }
}