package com.example.boletinut3

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio4)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val idsCuadrantes = arrayOf(
            R.id.cuadrante1, R.id.cuadrante2, R.id.cuadrante3,
            R.id.cuadrante4, R.id.cuadrante5, R.id.cuadrante6,
            R.id.cuadrante7, R.id.cuadrante8, R.id.cuadrante9
        )

        for (i in idsCuadrantes.indices) {
            findViewById<FrameLayout>(idsCuadrantes[i])?.setOnClickListener {
                Toast.makeText(this, "Cuadrante ${i + 1} seleccionado", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.btnVolverEx4)?.setOnClickListener {
            finish()
        }
    }
}