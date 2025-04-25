
package com.example.myapplication.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class RegistrarseActivity : AppCompatActivity () {

    private lateinit var editTextNombres: EditText
    private lateinit var editTextApellido: EditText
    private lateinit var editTextSemestre: EditText
    private lateinit var editTextCorreo: EditText
    private lateinit var editTextContrasena: EditText
    private lateinit var editTextRecontrasena: EditText
    private lateinit var editTextPrograma: EditText
    private lateinit var buttonRegistro: Button
    private lateinit var TyC: CheckBox

    private lateinit var sharedPreference: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)


        Log.d("registrarActivity", "onCreate: Inicializando el Activity de Registro")

        editTextNombres = findViewById(R.id.nombre_registro)
        editTextApellido = findViewById(R.id.apellidos_registro)
        editTextCorreo = findViewById(R.id.correo_registro)
        editTextPrograma = findViewById(R.id.programa_registro)
        editTextSemestre = findViewById(R.id.semestre)
        editTextContrasena = findViewById(R.id.contrasena_registro)
        editTextRecontrasena = findViewById(R.id.repContra_registro)
        buttonRegistro = findViewById(R.id.btn_registrarse)
        TyC = findViewById(R.id.TyC_regitro)

        //Archivo de almacenamiento local
        sharedPreference = getSharedPreferences("UserData", MODE_PRIVATE)

        buttonRegistro.setOnClickListener {
            if (ValidarCampos()) {
                GuardarDatos()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun ValidarCampos(): Boolean {
        val nombres = editTextNombres.text.toString().trim()
        val apellido = editTextApellido.text.toString().trim()
        val correo = editTextCorreo.text.toString().trim()
        val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
        val Programa = editTextPrograma.text.toString().trim()
        val semestre = editTextSemestre.text.toString().trim()
        val contrasena = editTextContrasena.text.toString().trim()
        val recontrasena = editTextRecontrasena.text.toString().trim()
        val TeryCond = TyC.isChecked

        if (nombres.isEmpty()) {
            Toast.makeText(this, "el campo nombre es requerido", Toast.LENGTH_LONG).show()
            return false
        } else if (apellido.isEmpty()) {
            Toast.makeText(this, "el campo  apellido es requerido", Toast.LENGTH_LONG).show()
            return false
        } else if (correo.isEmpty()) {
            Toast.makeText(this, "el campo correo esta vacio", Toast.LENGTH_LONG).show()
            return false
        } else if (!correo.matches(emailPattern.toRegex())) {
            Toast.makeText(
                this,
                "debe ser correo electronico debe tener @ y .com o .edu",
                Toast.LENGTH_LONG
            ).show()
            return false
        }
        else if (Programa.isEmpty()) {
            Toast.makeText(this, "el campo es Programa es requerido", Toast.LENGTH_LONG).show()
            return false}
        else if (semestre.isEmpty()) {
            Toast.makeText(this, "el campo semestre es requerido", Toast.LENGTH_LONG).show()
            return false
        } else if (contrasena.isEmpty()) {
            Toast.makeText(this, "el campo es contraseña requerido", Toast.LENGTH_LONG).show()
            return false
        }else if (contrasena != recontrasena){
            Toast.makeText(this, "la contraseña es diferente", Toast.LENGTH_LONG).show()
            return false
        }else if(!TeryCond){
            Toast.makeText(this, "Debe aceptar los términos y condiciones", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

    private fun GuardarDatos(){
        val editor = sharedPreference.edit()

        editor.putString("nombres",editTextNombres.text.toString().trim())
        editor.putString("apellidos",editTextApellido.text.toString().trim())
        editor.putString("correo",editTextCorreo.text.toString().trim())
        editor.putString("programa",editTextPrograma.text.toString().trim())
        editor.putString("semestre",editTextSemestre.text.toString().trim())
        editor.putString("contrasena",editTextContrasena.text.toString().trim())
        editor.apply()

        Toast.makeText(this,"registro exitoso", Toast.LENGTH_LONG).show()

    }
    override fun onStart() {
        super.onStart()
        Log.d("Activity registrar", "esta en estado on start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity registrar", "esta en estado onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Activity registrar", "esta en estado onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Activity registrar", "esta en estado onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity registrar", "esta en estado onDestroy")

    }
}