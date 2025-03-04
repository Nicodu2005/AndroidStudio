package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity (){

    private lateinit var buttonperfil : Button
    private lateinit var linkregistro: TextView
    private lateinit var linkrecucontra: TextView
    private lateinit var sharedPreference: SharedPreferences
    private lateinit var getTextCorreo: String
    private lateinit var getTextContrasena: String
    private lateinit var Acorreo : EditText
    private lateinit var Acontrasena : EditText


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreference = getSharedPreferences("UserData", MODE_PRIVATE)

        linkregistro=findViewById(R.id.registrate_login)
        linkregistro.setOnClickListener {
            rediregistro()
        }
        linkrecucontra=findViewById(R.id.RecuperarC)
        linkrecucontra.setOnClickListener {
            redicontra()
        }

        buttonperfil=findViewById(R.id.btn_ingresar_login)
        buttonperfil.setOnClickListener {
           login()

        }

    }


    private fun login() {


        getTextCorreo = sharedPreference.getString("correo", "Useremail") ?: "Useremail";
        getTextContrasena =
            sharedPreference.getString("contrasena", "Usercontrasena") ?: "Usercontrasena";

        Acorreo = findViewById(R.id.input_Login)
        Acontrasena = findViewById(R.id.input_password)

        val correoIngresado = Acorreo.text.toString().trim()
        val contrasenaIngresado = Acontrasena.text.toString().trim()

        if (correoIngresado == getTextCorreo && contrasenaIngresado == getTextContrasena) {
            // Login exitoso
            Toast.makeText(this, "Login exitoso", Toast.LENGTH_SHORT).show()
            rediperfil()
        } else {
            // Login fallido
            Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()


        }
    }

    private fun rediperfil(){
        val intent = Intent(this,PerfilActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun redicontra(){
        val intent = Intent(this,RcontrasenaActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun rediregistro(){
        val intent = Intent(this,RegistrarseActivity::class.java)
        startActivity(intent)
        finish()
    }

}