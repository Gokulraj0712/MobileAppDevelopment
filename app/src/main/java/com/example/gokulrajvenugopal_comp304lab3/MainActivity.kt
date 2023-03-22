package com.example.gokulrajvenugopal_comp304lab3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

/*
Student Name: Gokulraj Venugopal
Student ID: 301202722
 */

class MainActivity : AppCompatActivity() {

    lateinit var listview : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listview = findViewById<ListView>(R.id.lstView)


        listview.setOnItemClickListener(OnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
            if (position == 0) {
                val intent = Intent(this, CanvasActivity::class.java)
                startActivity(intent)
            } else if (position == 1) {
                val intent = Intent(this, DateActivity::class.java)
                startActivity(intent)
            }
            else if(position==2){
                val intent =Intent(this,AnimationActivity::class.java)
                startActivity(intent)
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}