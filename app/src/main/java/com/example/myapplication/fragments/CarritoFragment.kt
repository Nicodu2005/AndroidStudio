package com.example.myapplication.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.myapplication.R

class CarritoFragment : Fragment() {



    private lateinit var sharedPreferences1: SharedPreferences
    private lateinit var sharedPreferences2: SharedPreferences
    private lateinit var sharedPreferences3: SharedPreferences
    private lateinit var sharedPreferences4: SharedPreferences
    private lateinit var sharedPreferences5: SharedPreferences
    private lateinit var btnlimpiar: Button

    private lateinit var nombreProducto: String
    private lateinit var valorProducto: String
    private lateinit var cantidadProducto: String




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_carrito , container, false)


            // INCIALIZACION DE SHARED PREFERENCES      
        sharedPreferences1 = requireActivity().getSharedPreferences("dataBalon", Context.MODE_PRIVATE)
        sharedPreferences2 = requireActivity().getSharedPreferences("dataropa", Context.MODE_PRIVATE)
        sharedPreferences3 = requireActivity().getSharedPreferences("datahogar", Context.MODE_PRIVATE)
        sharedPreferences4 = requireActivity().getSharedPreferences("dataelectronica", Context.MODE_PRIVATE)
        sharedPreferences5= requireActivity().getSharedPreferences("dataaccesorios", Context.MODE_PRIVATE)

        btnlimpiar=view.findViewById(R.id.btnlimpiar)
        btnlimpiar.setOnClickListener{
            borrarCarrito()
        }

        val tvCarrito = view.findViewById<TextView>(R.id.tv_carrito)

        //CREACION DEL MAP Y CREACION DE OBJETOS
        val productos = mapOf(
                "balon" to sharedPreferences1,
                "ropa" to sharedPreferences2,
                "hogar" to sharedPreferences3,
                "electronica" to sharedPreferences4,
                "accesorios" to sharedPreferences5
            )

        val contenidoCarrito = StringBuilder()
        for ((key, value) in productos) {
        //CLAVE VALOR DEL MAP
            nombreProducto = value.getString("nombreproducto", "Nombre del producto") ?: "Nombre del producto".trim()
            valorProducto = value.getString("Valor", "Valor del producto") ?: "Valor del producto".trim()
            cantidadProducto = value.getString("CantidadProducto", "Cantidad del producto") ?: "Cantidad del producto".trim()

            val valorInt = valorProducto.toIntOrNull()
            val cantidadInt = cantidadProducto.toIntOrNull()



        //REALIZA VALIDACION DE QUE VALOR NO SEA IGUAL AL DEFECTO PARA MOSTRAR
            if (nombreProducto != "Nombre del producto" && valorProducto!= "Valor del producto" && cantidadProducto !="Cantidad del producto") {
                contenidoCarrito.append("🛒 ${key.uppercase()}\n")
                contenidoCarrito.append("Nombre: $nombreProducto\n")
                contenidoCarrito.append("Valor: $valorProducto\n")
                contenidoCarrito.append("Cantidad: $cantidadProducto\n\n")
                if (valorInt != null && cantidadInt != null) {
                    val subtotal = valorInt * cantidadInt
                    contenidoCarrito.append("Subtotal: $subtotal\n\n")
                }
            }

        }
        tvCarrito.text = contenidoCarrito.toString()
        return view
    }

    private fun borrarCarrito() {
        sharedPreferences1.edit().clear().apply()
        sharedPreferences2.edit().clear().apply()
        sharedPreferences3.edit().clear().apply()
        sharedPreferences4.edit().clear().apply()
        sharedPreferences5.edit().clear().apply()
    }
}