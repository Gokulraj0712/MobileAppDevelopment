package com.example.gokulrajvenugopal_comp304lab3

import android.app.AlertDialog
import android.graphics.*
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*
Student Name: Gokulraj Venugopal
Student ID: 301202722
 */

class CanvasActivity : AppCompatActivity() {
    private lateinit var reusableImageView: ImageView
    private lateinit var textView: TextView

    //
    private var startx = 0
    private var starty = 0
    private var endx = 0
    private var endy = 0

    //
    private lateinit var paint: Paint
    private lateinit var bitmap: Bitmap
    private lateinit var canvas: Canvas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canvas)
        val spinner = findViewById<Spinner>(R.id.spinner1)
        val dataList = mutableListOf<Int>()
        for (i in 10 until 100 step 5) {
            dataList.add(i)
        }
        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dataList)
        spinner.adapter = arrayAdapter

        paint = Paint()
        paint.color = Color.RED
        //paint.strokeWidth = 30f

        bitmap = Bitmap.createBitmap(
            windowManager
                .defaultDisplay.width, windowManager
                .defaultDisplay.height, Bitmap.Config.ARGB_8888
        )

        canvas = Canvas(bitmap)
        canvas.drawColor(Color.WHITE) //background
        //
        reusableImageView = findViewById(R.id.ImageViewForDrawing)
        reusableImageView.setImageBitmap(bitmap)
        reusableImageView.visibility = View.VISIBLE

        canvas.drawPoint(1f, 1f, paint)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                i: Int,
                l: Long
            ) {
                paint.strokeWidth = dataList[i].toFloat()
            }

            // If no option selected
            override fun onNothingSelected(arg0: AdapterView<*>?) {}
        }

        textView = findViewById(R.id.help)
        textView.text = "Use Arrow Keys to draw ! "
    }

    fun drawright(view: View) {
        reusableImageView.isFocusable = true
        reusableImageView.requestFocus()
        endx += 10
        canvas.drawLine(startx.toFloat(), starty.toFloat(), endx.toFloat(), endy.toFloat(), paint)
        startx = endx
        starty = endy
        //moveRect(canvas);
        reusableImageView.invalidate()
        textView.text = "X= $endx  Y= $endy"
    }

    fun drawdown(view: View) {
        reusableImageView.isFocusable = true
        reusableImageView.requestFocus()
        endy += 10
        canvas.drawLine(startx.toFloat(), starty.toFloat(), endx.toFloat(), endy.toFloat(), paint)
        startx = endx
        starty = endy
        //moveRect(canvas);
        reusableImageView.invalidate()
        textView.text = "X= $endx  Y= $endy"
    }

    fun drawleft(view: View) {
        reusableImageView.isFocusable = true
        reusableImageView.requestFocus()
        endx -= 10
        canvas.drawLine(startx.toFloat(), starty.toFloat(), endx.toFloat(), endy.toFloat(), paint)
        startx = endx
        starty = endy
        //moveRect(canvas);
        reusableImageView.invalidate()
        textView.text = "X= $endx  Y= $endy"
        if (endx<=0)
        {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Negative X-Axis Value ")
            builder.setMessage("No Line will  be drawn for Negative X-Axis Values!!")
            builder.setPositiveButton("OK", null)
            val dialog = builder.create()
            dialog.show()
        }
    }

    fun drawup(view: View) {
        reusableImageView.isFocusable = true
        reusableImageView.requestFocus()
        endy -= 10
        canvas.drawLine(startx.toFloat(), starty.toFloat(), endx.toFloat(), endy.toFloat(), paint)
        startx = endx
        starty = endy
//moveRect(canvas);
        reusableImageView.invalidate()
        textView.text = "X= $endx Y= $endy"
        if (endy<=0)
        {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Negative Y-Axis Value ")
            builder.setMessage("No Line will  be drawn for Negative Y-Axis Values!!")
            builder.setPositiveButton("OK", null)
            val dialog = builder.create()
            dialog.show()
        }
    }


    fun redline(view: View) {
        paint.color = Color.RED
    }

    fun cyan(view: View) {
        paint.color = Color.CYAN
    }

    fun yellowline(view: View) {
        paint.color = Color.YELLOW
    }

    fun clearall(view: View) {
        canvas.drawColor(Color.rgb(95, 75, 92)) //background
        canvas.drawColor(Color.WHITE)
        startx = 0
        starty = 0
        endx = 0
        endy = 0
        textView.text = "Use Arrow Keys to draw ! "
    }
}