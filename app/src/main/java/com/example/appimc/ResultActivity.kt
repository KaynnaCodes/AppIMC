package com.example.appimc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var textHeight: TextView
    private lateinit var textWeight: TextView
    private lateinit var textResult: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textHeight = findViewById(R.id.text_height)
        textWeight = findViewById(R.id.text_weight)
        textResult = findViewById(R.id.text_result)

        val bundle = intent.extras
        if (bundle != null){

            val weight = bundle.getDouble("peso")
            val height = bundle.getDouble("altura")

            textWeight.text = "peso informado  $weight kg"
            textHeight.text = "peso informado  $height m"

            val imc = weight / (height * height)

            val result = if (imc < 18.5){
                "Baixo"
        }else if(imc in 18.5..24.9){
               "normal"

            }else if(imc in 25.0..29.9){
                 "sobre peso"
            }else{
                 "obeso"
            }
            textResult.text = result

        }
    }
}