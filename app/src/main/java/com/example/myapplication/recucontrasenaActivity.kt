package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences
import android.util.Log
import android.widget.Button
import android.widget.EditText

import android.widget.Toast


class RcontrasenaActivity : AppCompatActivity () {

    private lateinit var btnRecuperar: Button
    private lateinit var correoGuardado: String
    private lateinit var correoIntruducido: EditText
    private lateinit var sharedPreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recontrasena)
        sharedPreference = getSharedPreferences("UserData", MODE_PRIVATE)

        btnRecuperar = findViewById(R.id.btn_continuar_rec)

        btnRecuperar.setOnClickListener {
            compararCorreo()
        }


    }

    private fun compararCorreo() {
        correoGuardado = sharedPreference.getString("correo", "Useremail") ?: "Useremail";
        correoIntruducido = findViewById(R.id.recontrasena_correo);
        val asigCorreo = correoIntruducido.text.toString().trim();

        if (asigCorreo == correoGuardado) {
            Toast.makeText(
                this,
                "Se ha enviado un correo de recuperacion de contraseña email $correoGuardado",
                Toast.LENGTH_SHORT
            ).show()
            rediLogin()
        } else {
            Toast.makeText(this, "el correo no ha sido encontrado", Toast.LENGTH_SHORT).show()
        }

    }

    private fun rediLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()

    }

    override fun onStart() {
        super.onStart()
        Log.d("Activity recucontrasena", "esta en estado on start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity recucontrasena", "esta en estado onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Activity recucontrasena", "esta en estado onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Activity recucontrasena", "esta en estado onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity recucontrasena", "esta en estado onDestroy")

    }
}