package com.example.actividad16_10_2023

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class BarrasActivity : AppCompatActivity() {

    //Instancias
    private lateinit var barra: ProgressBar
    private lateinit var barra2: ProgressBar
    private lateinit var barra3: SeekBar
    private lateinit var activityContext : Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barras)
        activityContext = this
        //Asociacion con components
        barra = findViewById(R.id.pbHorizontal)
        barra2 = findViewById(R.id.pbHorizontal2)
        barra3 = findViewById(R.id.sbBarra1)

        //Valor limite de la barra
        barra.max = 500
        barra2.max = 300
        //Valor de inicio de la barra
        barra.progress = 0
        barra2.progress = 0

        //Corrutinas: API que permite escribir codigo asincrono, como Hilos
        //Se requiere instalar una dependencia en Modulo de Gradle
        GlobalScope.launch {
            administrarProgressBarra(barra)
            administrarProgressBarra(barra2)
            administrarSeekBarra(barra3)

//            barraRating.setOnSeekBarChangeListener{ ratingBar,rating, fromUser ->
//                valor.text = "${rating} /${barraRating.numStarts}"
//            }

        }//GlobalScope

        barra3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Toast.makeText(activityContext, "Moviste el apuntador",Toast.LENGTH_SHORT).show()
                if(barra3.progress > 50){
                    barra3.thumb = getDrawable(R.drawable.baseline_directions_bike_24)
                }else{
                    barra3.thumb = getDrawable(R.drawable.baseline_directions_bike_24)//Cambia
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Implementa acciones a realizar cuando se inicia la interacción con el SeekBar
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Implementa acciones a realizar cuando se detiene la interacción con el SeekBar
            }
        })

    }//onCreate


    private fun administrarSeekBarra(barra3: SeekBar?) {

    }

    private fun administrarProgressBarra(barra: ProgressBar?) {
        if(barra != null){
            while(barra.progress < barra.max){
                //Esperar un milisegundo
                sleep(100L)
                //Incrementar en 5 unidades la barra
                //Dos maneras: (1Tradicional, 2 Por metodo)
                //Barra.progress *= 5
                barra.incrementProgressBy(5)
                barra.incrementSecondaryProgressBy(10)
                if(barra.id == R.id.pbHorizontal2){
                    barra.incrementProgressBy(2)
                    barra.incrementSecondaryProgressBy(5)
                }//if barra.if
            }//while
        }//if barra !null
    }//AdministradorBarra
}