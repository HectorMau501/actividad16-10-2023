package com.example.actividad16_10_2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import java.util.Calendar

class Calendario : AppCompatActivity() {

    private lateinit var calendario: CalendarView
    private lateinit var fecha: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)

        //Asociar con componentes grafico
        calendario = findViewById(R.id.cvCalendario)
        fecha = findViewById(R.id.txtFecha)
        //Escucha para el cambio de fecha
        calendario.setOnDateChangeListener{ view, year, month, dayOfMonth ->
            var date = "$dayOfMonth/${month+1}/$year"
            fecha.text = "Fecha: $date"
        }

        //Instancias para manejar una fecha en especifico
        var fechaFija = Calendar.getInstance()
        //Definir la fecha en el calendario
        fechaFija.set(2026,5-1,8)
        //Relacionar con componentes CalendarView
        calendario.date = fechaFija.timeInMillis

        //Obtener el primer dia de la semana
        var d = calendario.firstDayOfWeek
        //Establecer inicio de calendario en lunes
        calendario.firstDayOfWeek = (d+1) % 7
    }//onCreate
}