package com.example.boletinut3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnEjercicio1 = findViewById<Button>(R.id.btnEjercicio1)
        val btnEjercicio2 = findViewById<Button>(R.id.btnEjercicio2)
        val btnEjercicio3 = findViewById<Button>(R.id.btnEjercicio3)
        val btnEjercicio4 = findViewById<Button>(R.id.btnEjercicio4)
        val btnEjercicio5 = findViewById<Button>(R.id.btnEjercicio5)
        val btnEjercicio6 = findViewById<Button>(R.id.btnEjercicio6)

        btnEjercicio1.setOnClickListener {
            val intent = Intent(this, Ejercicio1Activity::class.java)
            startActivity(intent)
        }

        btnEjercicio2.setOnClickListener {
            val intent = Intent(this, Ejercicio2Activity::class.java)
            startActivity(intent)
        }

        btnEjercicio3.setOnClickListener {
            val intent = Intent(this, Ejercicio3Activity::class.java)
            startActivity(intent)
        }

        btnEjercicio4.setOnClickListener {
            val intent = Intent(this, Ejercicio4Activity::class.java)
            startActivity(intent)
        }

        btnEjercicio5.setOnClickListener {
            val intent = Intent(this, Ejercicio5Activity::class.java)
            startActivity(intent)
        }

        btnEjercicio6.setOnClickListener {
            val intent = Intent(this, Ejercicio6Activity::class.java)
            startActivity(intent)
        }
    }
}