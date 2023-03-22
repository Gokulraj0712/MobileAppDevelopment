package com.example.gokulrajvenugopal_comp304lab3

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import java.text.SimpleDateFormat
import java.util.*
/*
Student Name: Gokulraj Venugopal
Student ID: 301202722
 */

class DateTextView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attributeSet, defStyleAttr) {

    companion object {
        private const val DEFAULT_DATE_FORMAT = "EEEE, MMMM d, yyyy"
    }
    private var longDateFormat: SimpleDateFormat = SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.getDefault())

    init {
        attributeSet?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.DateTextView)
            val dateFormat = typedArray.getString(R.styleable.DateTextView_longDate)
            if (!dateFormat.isNullOrEmpty()) {
                longDateFormat = SimpleDateFormat(dateFormat, Locale.getDefault())
            }
            typedArray.recycle()
        }
    }

    fun setDate(date: Date) {
        text = longDateFormat.format(date)
    }
}