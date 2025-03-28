package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R


class HomeActivity : AppCompatActivity (){

    private lateinit var buttonContinuar : Button
    private lateinit var linkregistroHome: TextView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        linkregistroHome=findViewById(R.id.registro_home)
        linkregistroHome.setOnClickListener {
            rediregistroHome()
        }

        buttonContinuar=findViewById(R.id.boton_Comineza_home)
        buttonContinuar.setOnClickListener {
            redirrecion()
        }

    }

    private fun redirrecion (){

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()

    }
    private fun rediregistroHome(){
        val intent = Intent(this, RegistrarseActivity::class.java)
        startActivity(intent)
        finish()
    }


    override fun onStart() {
        super.onStart()
        Log.d("Activity home", "esta en estado on start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity home", "esta en estado onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Activity home", "esta en estado onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Activity home", "esta en estado onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity home", "esta en estado onDestroy")
    }
}



