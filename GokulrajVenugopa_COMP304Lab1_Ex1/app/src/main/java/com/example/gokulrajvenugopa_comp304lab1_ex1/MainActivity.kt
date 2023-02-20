package com.example.gokulrajvenugopa_comp304lab1_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.gokulrajvenugopa_comp304lab1_ex1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        setTitle("My First App");



        binding.send.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val textView = binding.nameEditTextViewFirstActivity.text

           Log.e(TAG,textView.toString())
            intent.putExtra("DATA", textView.toString() )
            startActivity(intent)
        }
    }
}