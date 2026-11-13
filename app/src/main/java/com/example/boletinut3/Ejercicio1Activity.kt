package com.example.boletinut3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class Ejercicio1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etUrl = findViewById<TextInputEditText>(R.id.etUrl)
        val btnNavegar = findViewById<Button>(R.id.btnNavegar)
        val btnVolverEx1 = findViewById<Button>(R.id.btnVolverEx1)

        btnNavegar.setOnClickListener {
            var urlTexto = etUrl.text.toString().trim()

            if (urlTexto.isEmpty()) {
                Toast.makeText(this, "Por favor, introduce una URL", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!urlTexto.startsWith("http://") && !urlTexto.startsWith("https://")) {
                urlTexto = "https://$urlTexto"
            }

            if (Patterns.WEB_URL.matcher(urlTexto).matches()) {
                val intentNavegador = Intent(Intent.ACTION_VIEW, Uri.parse(urlTexto))
                startActivity(intentNavegador)
            } else {
                Toast.makeText(this, "La URL introducida no es válida", Toast.LENGTH_SHORT).show()
            }
        }

        btnVolverEx1.setOnClickListener {
            finish()
        }
    }
}