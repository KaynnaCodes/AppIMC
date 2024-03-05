package com.example.appimc

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    //creating buttons
    private lateinit var btnCalculate:Button
    //creating texts
    private lateinit var editWeight:EditText
    private lateinit var editHeight:EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //declaring functions
        btnCalculate = findViewById(R.id.btnCalculate)
        editWeight = findViewById(R.id.editWeight)
        editHeight = findViewById(R.id.editHeight)

        //open new activy
        btnCalculate.setOnClickListener {
            val i = Intent(this, ResultActivity::class.java)

            //
            val weight =editWeight.text.toString()
            val height =editHeight.text.toString()

            if (weight.isNotEmpty() && height.isNotEmpty()){

                i.putExtra("peso", weight.toDouble())
                i.putExtra("altura", height.toDouble())
            }

            startActivity(i)
        }
    }
}