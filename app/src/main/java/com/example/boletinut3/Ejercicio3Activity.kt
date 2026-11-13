package com.example.boletinut3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio3)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnBandera1 = findViewById<Button>(R.id.btnBandera1)
        val btnBandera2 = findViewById<Button>(R.id.btnBandera2)
        val btnBandera3 = findViewById<Button>(R.id.btnBandera3)
        val btnVolverPrincipal = findViewById<Button>(R.id.btnVolverPrincipal)

        btnBandera1.setOnClickListener {
            startActivity(Intent(this, Ejercicio3Bandera1Activity::class.java))
        }

        btnBandera2.setOnClickListener {
            startActivity(Intent(this, Ejercicio3Bandera2Activity::class.java))
        }

        btnBandera3.setOnClickListener {
            startActivity(Intent(this, Ejercicio3Bandera3Activity::class.java))
        }

        btnVolverPrincipal.setOnClickListener {
            finish()
        }
    }
}