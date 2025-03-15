package com.example.myapplication


import android.os.Bundle
import android.util.Log
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
    private lateinit var resultadoHospedaje: TextView;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

            calcular = findViewById(R.id.button_calcular)
            calcular.setOnClickListener {
                calculo_hospedaje()
        }
    }




    private fun calculo_hospedaje(){
        numeroPersona = findViewById(R.id.input_personas)
        destino = findViewById(R.id.input_destino)
        categoriaPlan = findViewById(R.id.input_categoria)
        dias = findViewById(R.id.input_dias)
        resultadoHospedaje=findViewById(R.id.costoHospedaje)

       val  numerospersonasInt=numeroPersona.text.toString().toInt();
        val numerosdias=dias.text.toString().toInt();
        val categoriaPlanString =categoriaPlan.text.toString().trim();
        Log.d("categoria", categoriaPlanString)
        if (categoriaPlanString =="economica"){

            val economico = 5;
            val plan1 = numerospersonasInt* economico * numerosdias;
            val resultado = plan1.toString();
            resultadoHospedaje.setText(resultado);
            Log.d("resultado de operacion", resultado)

        }else if (categoriaPlanString == "estandar") {
            val estandar = 7;
            val plan2 = numerospersonasInt * estandar * numerosdias;
            val resultado = plan2.toString();
            resultadoHospedaje.setText(resultado)
            Log.d("resultado de operacion", resultado)
        }else if (categoriaPlanString == "premium") {
            val premium = 10;
            val plan3 = numerospersonasInt * premium * numerosdias;
            val resultado = plan3.toString();
            resultadoHospedaje.setText(resultado)
            Log.d("resultado de operacion", resultado)
        }
}
}
