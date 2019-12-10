package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{ calBMI() }
        buttonReset.setOnClickListener{ resetBut() }
    }

    private fun calBMI(){
        val weightEdit : EditText = findViewById(R.id.editTextWeight)
        val weight : Double = weightEdit.text.toString().toDouble()

        val heightEdit : EditText = findViewById(R.id.editTextHeight)
        val height : Double = heightEdit.text.toString().toDouble()

        val calB : Double = (weight / (height * height)) * 10000
        val calBmi : Double = String.format("%.2f", calB).toDouble()

        if (calBmi < 18.5){
            findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.under)
            findViewById<TextView>(R.id.textViewBMI).text = "BMI : $calBmi"
        }else if (calBmi in 18.5..24.9){
            findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.normal)
            findViewById<TextView>(R.id.textViewBMI).text = "BMI : $calBmi"
        }else if (calBmi >= 25){
            findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.over)
            findViewById<TextView>(R.id.textViewBMI).text = "BMI : $calBmi"
        }
    }

    private fun resetBut () {
        val editW : EditText = findViewById(R.id.editTextWeight)
        val editH : EditText = findViewById(R.id.editTextHeight)
        val image : ImageView = findViewById(R.id.imageViewProfile)
        val bmi : TextView = findViewById(R.id.textViewBMI)

        editW.text.clear()
        editH.text.clear()
        image.setImageResource(R.drawable.empty)
        bmi.text = "BMI : "
    }
}
