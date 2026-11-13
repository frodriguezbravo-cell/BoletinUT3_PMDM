package com.example.boletinut3

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.materialswitch.MaterialSwitch
import com.google.android.material.textfield.TextInputEditText

class Ejercicio6Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio6)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNombre = findViewById<TextInputEditText>(R.id.etNombre)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val rgOpciones = findViewById<RadioGroup>(R.id.rgOpciones)
        val switchNotificaciones = findViewById<MaterialSwitch>(R.id.switchNotificaciones)
        val btnGuardarPerfil = findViewById<Button>(R.id.btnGuardarPerfil)

        btnGuardarPerfil.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val email = etEmail.text.toString().trim()

            if (nombre.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedRadioId = rgOpciones.checkedRadioButtonId
            val selectedRadio = findViewById<RadioButton>(selectedRadioId)
            val preferencia = selectedRadio?.text?.toString() ?: "Sin preferencia"

            val notifEstado = if (switchNotificaciones.isChecked) "Activadas" else "Desactivadas"

            val mensaje = "Perfil guardado: $nombre | Notifs: $notifEstado ($preferencia)"
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }
    }
}