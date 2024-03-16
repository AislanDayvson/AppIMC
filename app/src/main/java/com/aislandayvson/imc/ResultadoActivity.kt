package com.aislandayvson.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {

    private lateinit var text_peso: TextView
    private lateinit var text_altura: TextView
    private lateinit var text_resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        text_peso = findViewById(R.id.text_peso)
        text_altura = findViewById(R.id.text_altura)
        text_resultado = findViewById(R.id.text_resultado)

        val bundle = intent.extras

        if( bundle != null){

                val peso = bundle.getDouble("peso")
                val altura = bundle.getDouble("altura")

                text_peso.text = "Peso informado: $peso kg"
                text_altura.text = "Altura informada: $altura m"

                val imc = peso / (altura * altura)

                val resultado = if(imc < 18.5){
                     "IMC Baixo"
                }else if(imc in 18.5..24.9){
                     "IMC Normal"
                }else if(imc in 25.0 .. 25.9 ){
                     "IMC Sobrepeso"
                }else{
                    "IMC Obesidade"
                }

                text_resultado.text = resultado

        }
    }
}