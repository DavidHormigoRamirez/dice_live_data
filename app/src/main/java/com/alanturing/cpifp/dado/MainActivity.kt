package com.alanturing.cpifp.dado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    private val viewModel:DadoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val texto = findViewById<TextView>(R.id.resultado)
        val boton = findViewById<Button>(R.id.suma)

        boton.setOnClickListener {
            // Tiramos el dado
            viewModel.roll()
        }
        // Creamos un observador con un callback que se
        // va a ejcutar cada vez que observe un cambio en
        // el flujo
        val observer = Observer<Int> {
                texto.text = it.toString()
        }
        // Observamos el LiveData y lo asociamos al observador
        viewModel.numero.observe(this,observer)
    }
}