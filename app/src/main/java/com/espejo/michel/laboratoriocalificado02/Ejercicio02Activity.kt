package com.espejo.michel.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ejercicio02Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio02)

        // Referencias a los elementos de la UI
        val inputNombre = findViewById<EditText>(R.id.inputNombre)
        val inputDireccion = findViewById<EditText>(R.id.inputDireccion)
        val inputProductos = findViewById<EditText>(R.id.inputProductos)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val btnLlamar = findViewById<Button>(R.id.btnLlamar)
        val btnWhatsapp = findViewById<Button>(R.id.btnWhatsapp)
        val btnMaps = findViewById<Button>(R.id.btnMaps)

        // Acción al pulsar "Registrar"
        btnRegistrar.setOnClickListener {
            val nombre = inputNombre.text.toString()
            val direccion = inputDireccion.text.toString()
            val productos = inputProductos.text.toString()

            if (nombre.isEmpty() || direccion.isEmpty() || productos.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Intent explícito para ir a otra actividad mostrando los datos
                val intent = Intent(this, DetalleActivity::class.java)
                intent.putExtra("nombre", nombre)
                intent.putExtra("direccion", direccion)
                intent.putExtra("productos", productos)
                startActivity(intent)
            }
        }

        // Acción al pulsar "Llamar"
        btnLlamar.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:123456789")  // Cambia el número por el que quieras
            startActivity(intent)
        }

        // Acción al pulsar "WhatsApp"
        btnWhatsapp.setOnClickListener {
            val nombre = inputNombre.text.toString()
            val productos = inputProductos.text.toString()
            val direccion = inputDireccion.text.toString()

            if (nombre.isNotEmpty() && productos.isNotEmpty() && direccion.isNotEmpty()) {
                val mensaje = "Hola $nombre, Tus productos: $productos están en camino a la dirección: $direccion"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://wa.me/?text=$mensaje")
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Acción al pulsar "MAPS"
        btnMaps.setOnClickListener {
            val direccion = inputDireccion.text.toString()
            if (direccion.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$direccion"))
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, ingresa una dirección", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
