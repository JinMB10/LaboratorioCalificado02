package com.espejo.michel.laboratoriocalificado02

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Ejercicio01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio01)

        // Referencias a los elementos en el XML
        val viewVerde = findViewById<View>(R.id.view)
        val btnMostrar = findViewById<Button>(R.id.button)
        val btnOcultar = findViewById<Button>(R.id.button2)

        // Mostrar el View cuando se presione el botón "Mostrar"
        btnMostrar.setOnClickListener {
            viewVerde.visibility = View.VISIBLE
            Log.d("Ejercicio01Activity", "El View se ha mostrado.")
        }

        // Ocultar el View cuando se presione el botón "Ocultar"
        btnOcultar.setOnClickListener {
            viewVerde.visibility = View.GONE
            Log.d("Ejercicio01Activity", "El View se ha ocultado.")
        }
    }
}
