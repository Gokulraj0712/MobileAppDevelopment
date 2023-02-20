package com.example.gokulrajvenugopal_test1_practise


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class VitaminActivity : AppCompatActivity() {
    private val checkedStates = IntArray(4)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vitamin)
    }

    fun onCheckboxClicked(view: View) {
        // Is the view now checked?
        val checked = (view as CheckBox).isChecked
        when (view.getId()) {
            R.id.chkVitaminA -> if (checked) checkedStates[0] = 1
            R.id.chkVitaminB -> if (checked) checkedStates[1] = 1
            R.id.chkVitaminC -> if (checked) checkedStates[2] = 1
            R.id.chkVitaminD -> if (checked) checkedStates[3] = 1
            else -> {}
        }
    }

    //
    //handling image button
    fun showChartActivity(v: View?) {
        //put selected items in Extras
        val intent = Intent(this, ChartActivity::class.java)
        intent!!.putExtra("checkedStates", checkedStates)
        //
        startActivity(intent)
    }

    //handling radio buttons
    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked = (view as RadioButton).isChecked
        when (view.getId()) {
            R.id.radio_button_No -> if (checked) Toast.makeText(this, "No", Toast.LENGTH_LONG).show()
            R.id.radio_button_Yes -> if (checked) Toast.makeText(this, "Yes", Toast.LENGTH_LONG)
                .show()
        }
    }


}
