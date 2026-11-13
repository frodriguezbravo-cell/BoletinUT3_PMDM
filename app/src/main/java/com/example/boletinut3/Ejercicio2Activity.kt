package com.example.boletinut3

import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnIniciar = findViewById<Button>(R.id.btnIniciarRetraso)
        val tvEstado = findViewById<TextView>(R.id.tvEstado)

        btnIniciar.setOnClickListener {
            btnIniciar.isEnabled = false
            tvEstado.text = "Estado: Navegando en 10 segundos..."
            tvEstado.setTextColor(Color.parseColor("#FF007F"))

            Toast.makeText(this, "Navegación programada en 10s", Toast.LENGTH_SHORT).show()

            val intentDestino = Intent(this, Ejercicio2DestinoActivity::class.java)

            val pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intentDestino,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )

            val handler = Handler(Looper.getMainLooper())

            handler.postDelayed({
                try {
                    pendingIntent.send()
                    finish()
                } catch (e: PendingIntent.CanceledException) {
                    e.printStackTrace()
                }
            }, 10000)
        }
    }
}