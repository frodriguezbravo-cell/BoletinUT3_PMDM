package com.example.boletinut3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio5Activity : AppCompatActivity() {

    private lateinit var tvDisplay: TextView
    private var primerNumero = 0.0
    private var operacionActual = ""
    private var esNuevaEntrada = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio5)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvDisplay = findViewById(R.id.tvDisplay)

        val botones = mapOf(
            R.id.btn0 to "0", R.id.btn1 to "1", R.id.btn2 to "2",
            R.id.btn3 to "3", R.id.btn4 to "4", R.id.btn5 to "5",
            R.id.btn6 to "6", R.id.btn7 to "7", R.id.btn8 to "8", R.id.btn9 to "9"
        )

        for ((id, valor) in botones) {
            findViewById<Button>(id)?.setOnClickListener {
                onNumeroPulsado(valor)
            }
        }

        findViewById<Button>(R.id.btnSuma)?.setOnClickListener { onOperacionPulsada("+") }
        findViewById<Button>(R.id.btnResta)?.setOnClickListener { onOperacionPulsada("-") }
        findViewById<Button>(R.id.btnMultiplicar)?.setOnClickListener { onOperacionPulsada("×") }
        findViewById<Button>(R.id.btnDividir)?.setOnClickListener { onOperacionPulsada("÷") }

        findViewById<Button>(R.id.btnLimpiar)?.setOnClickListener {
            tvDisplay.text = "0"
            primerNumero = 0.0
            operacionActual = ""
            esNuevaEntrada = true
        }

        findViewById<Button>(R.id.btnIgual)?.setOnClickListener {
            calcularResultado()
        }

        findViewById<Button>(R.id.btnVolverEx5)?.setOnClickListener {
            finish()
        }
    }

    private fun onNumeroPulsado(numero: String) {
        if (esNuevaEntrada || tvDisplay.text == "0") {
            tvDisplay.text = numero
            esNuevaEntrada = false
        } else {
            tvDisplay.text = "${tvDisplay.text}$numero"
        }
    }

    private fun onOperacionPulsada(op: String) {
        primerNumero = tvDisplay.text.toString().toDoubleOrNull() ?: 0.0
        operacionActual = op
        esNuevaEntrada = true
    }

    private fun calcularResultado() {
        if (operacionActual.isEmpty()) return
        val segundoNumero = tvDisplay.text.toString().toDoubleOrNull() ?: 0.0
        var resultado = 0.0

        when (operacionActual) {
            "+" -> resultado = primerNumero + segundoNumero
            "-" -> resultado = primerNumero - segundoNumero
            "×" -> resultado = primerNumero * segundoNumero
            "÷" -> resultado = if (segundoNumero != 0.0) primerNumero / segundoNumero else 0.0
        }

        tvDisplay.text = if (resultado % 1.0 == 0.0) {
            resultado.toInt().toString()
        } else {
            resultado.toString()
        }
        operacionActual = ""
        esNuevaEntrada = true
    }
}