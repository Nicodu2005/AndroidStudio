package com.example.myapplication


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class datosActivity: AppCompatActivity () {

    private lateinit var numeroPersona: EditText
    private lateinit var destino: EditText
    private lateinit var categoriaPlan: EditText
    private lateinit var dias: EditText
    private lateinit var calcular: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)
    }

    private fun calculo_hospedaje(){
        numeroPersona = findViewById(R.id.input_personas)
        destino = findViewById(R.id.input_destino)
        categoriaPlan = findViewById(R.id.input_categoria)
        dias = findViewById(R.id.input_dias)

        var npersonas=numeroPersona.Integer.parseInt()
        var ndias=dias.Integer.parseInt()


        if (categoriaPlan =="basica"){

            val basico = 5;
            val plan1 = npersonas * basico * ndias;

        }else if (categoriaPlan == "media")
             val medio = 7;
            val plan1 = npersonas * medio * ndias;
        else if (categoriaPlan == "premium")
            val premiun = 10;
            val plan1 = npersonas * premiun * ndias;

}
}
