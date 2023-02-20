package com.example.gokulrajvenugopal_test1_practise

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.widget.ImageView



class ChartActivity : AppCompatActivity() {
    private var imageView: ImageView? = null
    private var paint: Paint? = null
    private lateinit var bitmap: Bitmap
    private var canvas: Canvas? = null

    //
    var barStartY = 0
    var barY = 0
    var barHeight = 100

    //
    var checkedStates: IntArray? = IntArray(4)

    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)
        //
        this.supportActionBar!!.title = "Vitamin Chart"
        checkedStates = intent.extras!!.getIntArray("checkedStates")

        // set up the paint
        paint = Paint()
        paint?.color = Color.BLUE
        paint?.strokeWidth = 20F
        //create the big image view to show memory map
        imageView = findViewById(R.id.imageView)
        val width = resources.getDimension(R.dimen.img_width).toInt()
        val height = resources.getDimension(R.dimen.img_height).toInt()
        //
        //prepare drawing environment
        //create a bitmap as content view for the canvas
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        canvas = Canvas(bitmap)
        //set canvas background
        canvas?.drawColor(Color.BLACK)
        //set a bitmap as content view for the image
        imageView?.setImageBitmap(bitmap)
        //render the view to the canvas
        imageView?.draw(canvas)
        //
        try {
            //compute the width of vitamin A consumption and draw with blue
            val barWidthOfVitaminA = (checkedStates!![0] * width).toDouble()
            canvas?.drawRect(0F, barY.toFloat(),
                barWidthOfVitaminA.toInt().toFloat(), (barY + barHeight).toFloat(), paint!!
            )
            paint?.setTextSize(100F)
            paint?.setColor(Color.CYAN)
            canvas?.drawText("A", (width - 100).toFloat(), (barY + barHeight).toFloat(), paint!!)
            //compute the width of vitamin B consumption and draw with yellow
            val barWidthOfVitaminB = (checkedStates!![1] * width).toDouble()
            barY += barHeight
            paint?.setColor(Color.YELLOW)
            canvas?.drawRect(0F, barY.toFloat(),
                barWidthOfVitaminB.toInt().toFloat(), (barY + barHeight).toFloat(), paint!!
            )
            paint?.setTextSize(100F)
            paint?.setColor(Color.CYAN)
            canvas?.drawText("B", (width - 100).toFloat(), (barY + barHeight).toFloat(), paint!!)
            //compute the width of vitamin C consumtion and draw with magenta
            val barWidthOfVitaminC = (checkedStates!![2] * width).toDouble()
            barY += barHeight
            paint?.setColor(Color.MAGENTA)
            canvas?.drawRect(0F, barY.toFloat(),
                barWidthOfVitaminC.toInt().toFloat(), (barY + barHeight).toFloat(), paint!!
            )
            //compute the width of vitamin D consumtion and draw with green
            val barWidthOfVitaminD = (checkedStates!![3] * width).toDouble()
            barY += barHeight
            paint?.setColor(Color.GREEN)
            canvas?.drawRect(0F, barY.toFloat(),
                barWidthOfVitaminD.toInt().toFloat(), (barY + barHeight).toFloat(), paint!!
            )
        } catch (e: Exception) {
            e.message?.let { Log.d("exception", it) }
        }
        imageView?.invalidate() //refreshes the painting
    }
}
