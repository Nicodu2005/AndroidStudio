package com.example.myapplication.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class parcial_mi_logica_fragment : Fragment() {

    private lateinit var numeroPersona: EditText
    private lateinit var destino: EditText
    private lateinit var categoriaPlan: EditText
    private lateinit var dias: EditText
    private lateinit var calcular: Button
    private lateinit var costoHospedaje: TextView
    private lateinit var Costotransporte: TextView
    private lateinit var costoactividades: TextView
    private lateinit var sharedPreference: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.parcial_mi_logica, container, false)


        sharedPreference = requireContext().getSharedPreferences("Historico", MODE_PRIVATE)

        numeroPersona =view.findViewById(R.id.input_personas)
        destino = view.findViewById(R.id.input_destino)
        categoriaPlan = view.findViewById(R.id.input_categoria)
        dias = view.findViewById(R.id.input_dias)
        costoHospedaje=view.findViewById(R.id.costoHospedaje)
        costoactividades=view.findViewById(R.id.costoactividades)
        Costotransporte=view.findViewById(R.id.Costotransporte)




        calcular = view.findViewById(R.id.button_calcular)
        calcular.setOnClickListener {
            calculo_hospedaje()
            calculotrasnporte()
            calculodeactividades()

        }
        return view

    }
    fun calculo_hospedaje() {
        val editor = sharedPreference.edit()
        val numerospersonasInt = numeroPersona.text.toString().toInt()
        val numerosdias = dias.text.toString().toInt()
        val categoriaPlanString = categoriaPlan.text.toString().trim()

        Log.d("categoria", categoriaPlanString)
        if (categoriaPlanString == "economica") {

            val economico = 5
            val plan1 = numerospersonasInt * economico * numerosdias
            val resultado = plan1.toString()
            costoHospedaje.text = resultado
            Log.d("resultado de operacion", resultado)
            editor.putString("hospedaje",resultado)
            editor.apply()

        } else if (categoriaPlanString == "estandar") {
            val estandar = 7
            val plan2 = numerospersonasInt * estandar * numerosdias
            val resultado = plan2.toString()
            costoHospedaje.text = resultado
            Log.d("resultado de operacion", resultado)
            editor.putString("hospedaje",resultado)
            editor.apply()
        }
        else if (categoriaPlanString == "premium") {
            val premium = 10
            val plan3 = numerospersonasInt * premium * numerosdias
            val resultado = plan3.toString()
            costoHospedaje.text = resultado
            Log.d("resultado de operacion", resultado)
            editor.putString("hospedaje",resultado)
            editor.apply()
        }

        }
    private fun calculotrasnporte() {
        val editor = sharedPreference.edit()
        val nacional = 15
        val internacional=20
        val numerospersonasInt = numeroPersona.text.toString().toInt()
       val destinoInt = destino.text.toString().trim()

        if (destinoInt == "nacional"){
            val resultadohospedaje=numerospersonasInt * nacional
            val resultado=resultadohospedaje.toString()
            costoactividades.text = resultado
            Log.d("resultado de operacion",resultado)
            editor.putString("hospedaje",resultado)
            editor.apply()

        }else if (destinoInt=="internacional"){

            val resultadohospedaje=numerospersonasInt * internacional
            val resultado=resultadohospedaje.toString()
            costoactividades.text = resultado

            editor.putString("transporte",resultado)
            editor.apply()

            Log.d("resultado de operacion",resultado)

        }
    }

    private fun calculodeactividades(){
        val editor = sharedPreference.edit()
        val numerospersonasInt = numeroPersona.text.toString().toInt()

        val promediocomida=7

        val cantidaddeactividades= 10
        val precioactividad=15
        val alimentacion=numerospersonasInt * promediocomida
        val resultadoactivi= cantidaddeactividades * precioactividad * numerospersonasInt
        val resultadototal = alimentacion + resultadoactivi
        val resultadototalstring=resultadototal.toString()

        Costotransporte.text=resultadototalstring
        Log.d("resultado de operacion",resultadototalstring)
        editor.putString("actividades",resultadototalstring)
        editor.apply()
    }


}