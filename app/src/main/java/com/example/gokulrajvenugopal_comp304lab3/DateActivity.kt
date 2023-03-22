package com.example.gokulrajvenugopal_comp304lab3

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
/*
Student Name: Gokulraj Venugopal
Student ID: 301202722
 */
class DateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        val dateTextView = findViewById<DateTextView>(R.id.dateTextView)
        val calendar = Calendar.getInstance()
        calendar.set(2023, Calendar.MARCH, 21)
        dateTextView.setDate(calendar.time)
    }
}