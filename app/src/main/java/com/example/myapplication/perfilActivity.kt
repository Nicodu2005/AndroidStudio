package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences
import android.util.Log
import android.widget.TextView


class PerfilActivity : AppCompatActivity () {
    private lateinit var getTextNombres: String
    private lateinit var getTextApellido: String
    private lateinit var getTextTelefono: String
    private lateinit var getTextCorreo: String
    private lateinit var TextNombres: TextView
    private lateinit var TextApellido: TextView
    private lateinit var TextCorreo: TextView
    private lateinit var TextTelefono: TextView

    private lateinit var sharedPreference: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        sharedPreference = getSharedPreferences("UserData", MODE_PRIVATE)

        ObtenerDatos()
    }


    private fun ObtenerDatos() {


        getTextNombres = sharedPreference.getString("nombres", "Username") ?: "username";
        getTextApellido = sharedPreference.getString("apellidos", "Userlastname") ?: "Userlastname";
        getTextCorreo = sharedPreference.getString("correo", "Useremail") ?: "Useremail";
        getTextTelefono = sharedPreference.getString("telefono", "Usertelefono") ?: "Usertelefono";

        TextNombres = findViewById(R.id.nombres_perfil)
        TextApellido = findViewById(R.id.apellido_perfil)
        TextCorreo = findViewById(R.id.correo_perfil)
        TextTelefono = findViewById(R.id.telefono_perfil)

        TextNombres.setText(getTextNombres)
        TextApellido.setText(getTextApellido)
        TextCorreo.setText(getTextCorreo)
        TextTelefono.setText(getTextTelefono)

    }

    override fun onStart() {
        super.onStart()
        Log.d("Activity perfil", "esta en estado on start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity perfil", "esta en estado onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Activity perfil", "esta en estado onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Activity perfil", "esta en estado onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity perfil", "esta en estado onDestroy")
    }
}
