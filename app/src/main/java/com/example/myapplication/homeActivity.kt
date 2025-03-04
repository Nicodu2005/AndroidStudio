package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


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

        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish()

    }
    private fun rediregistroHome(){
        val intent = Intent(this,RegistrarseActivity::class.java)
        startActivity(intent)
        finish()
    }

}



