package com.example.myapplication.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class ProductosFragment : Fragment() {
    private lateinit var sharedPreferences1: SharedPreferences
    private lateinit var sharedPreferences2: SharedPreferences
    private lateinit var sharedPreferences3: SharedPreferences
    private lateinit var sharedPreferences4: SharedPreferences
    private lateinit var sharedPreferences5: SharedPreferences

    private lateinit var tv_titulobalon_products: TextView
    private lateinit var tv_cantidaddisponiblebalon: TextView
    private lateinit var tv_intValorProd1: TextView
    private lateinit var Et_baloncantidad: EditText
    private lateinit var btnAgregarbalon: Button

    private lateinit var tv_tituloropa: TextView
    private lateinit var tv_cantidaddisponibleropa: TextView
    private lateinit var tv_intValorProd2: TextView
    private lateinit var Et_ropacantidad: EditText
    private lateinit var btnAgregarropa: Button

    private lateinit var tv_titulohogar: TextView
    private lateinit var tv_cantidaddisponibleHogar: TextView
    private lateinit var tv_intValorProd3: TextView
    private lateinit var Ethogarcantidad: EditText
    private lateinit var btnAgregarhogar: Button

    private lateinit var tv_tituloElec: TextView
    private lateinit var tv_cantidaddisponiblePortatil: TextView
    private lateinit var tv_intValorProd4: TextView
    private lateinit var Et_portatilcantidad: EditText
    private lateinit var btnAgregarelec: Button

    private lateinit var tv_tituloAccesorio: TextView
    private lateinit var tv_cantidaddisponibleAccesorio: TextView
    private lateinit var tv_intValorProd5: TextView
    private lateinit var Et_accesoriocantidad: EditText
    private lateinit var btnAgregaraccesorios: Button




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_producto, container, false)
        sharedPreferences1 = requireActivity().getSharedPreferences("dataBalon", Context.MODE_PRIVATE)
        sharedPreferences2 = requireActivity().getSharedPreferences("dataropa", Context.MODE_PRIVATE)
        sharedPreferences3 = requireActivity().getSharedPreferences("datahogar", Context.MODE_PRIVATE)
        sharedPreferences4 = requireActivity().getSharedPreferences("dataelectronica", Context.MODE_PRIVATE)
        sharedPreferences5= requireActivity().getSharedPreferences("productos", Context.MODE_PRIVATE)

        tv_titulobalon_products = view.findViewById(R.id.titulobalon)
        tv_cantidaddisponiblebalon = view.findViewById(R.id.cantidaddisponiblebalon)
        tv_intValorProd1 = view.findViewById(R.id.valorbalon)
        Et_baloncantidad = view.findViewById(R.id.baloncantidad)
        btnAgregarbalon = view.findViewById(R.id.BtnagregarProd1)
        btnAgregarbalon.setOnClickListener{
            guardardatos()
        }

        tv_tituloropa = view.findViewById(R.id.tituloropa)
        tv_cantidaddisponibleropa = view.findViewById(R.id.cantidaddisponibleropa)
        tv_intValorProd2 = view.findViewById(R.id.intValorRopaStock)
        Et_ropacantidad = view.findViewById(R.id.valorropa)
        btnAgregarropa = view.findViewById(R.id.Btnagregarprod2)
        btnAgregarropa.setOnClickListener{
            guardardatosropa()
        }

        tv_titulohogar = view.findViewById(R.id.titulohogarProductos)
        tv_cantidaddisponibleHogar = view.findViewById(R.id.cantidaddisponibleHogar)
        tv_intValorProd3 = view.findViewById(R.id.valorhogarpro)
        Ethogarcantidad = view.findViewById(R.id.hogarcantidad)
        btnAgregarhogar = view.findViewById(R.id.Btnagregarropa)
        btnAgregarhogar.setOnClickListener{
            guardardatosHogar()
        }

        tv_tituloElec = view.findViewById(R.id.titulotechPortatil)
        tv_cantidaddisponiblePortatil = view.findViewById(R.id.cantidadstockPortatil)
        tv_intValorProd4 = view.findViewById(R.id.Valorprod_tech)
        Et_portatilcantidad = view.findViewById(R.id.techcantidad)
        btnAgregarelec = view.findViewById(R.id.Btnagregartech)
        btnAgregarelec.setOnClickListener{
            guardardatosElectronica()
        }

        tv_tituloAccesorio = view.findViewById(R.id.tituloAcces)
        tv_cantidaddisponibleAccesorio = view.findViewById(R.id.cantidaddisponibleGafas)
        tv_intValorProd5 = view.findViewById(R.id.valorgafas)
        Et_accesoriocantidad = view.findViewById(R.id.gafascantidad)
        btnAgregaraccesorios = view.findViewById(R.id.Btnagregarprod5)
        btnAgregaraccesorios.setOnClickListener{
            guardardatosAccesorio()
        }


        return view

    }
    private fun guardardatos(){
        val editor = sharedPreferences1.edit()

        editor.putString("nombreproducto",tv_titulobalon_products.text.toString().trim())
        editor.putString("cantidadDisponible",tv_cantidaddisponiblebalon.text.toString().trim())
        editor.putString("Valor",tv_intValorProd1.text.toString().trim())
        editor.putString("CantidadProducto",Et_baloncantidad.text.toString().trim())
        editor.apply()

        Toast.makeText(requireContext(),"registro exitoso", Toast.LENGTH_LONG).show()
    }
    private fun guardardatosropa(){
        val editor = sharedPreferences2.edit()
        editor.putString("nombreproducto",tv_tituloropa.text.toString().trim())
        editor.putString("cantidadDisponible",tv_cantidaddisponibleropa.text.toString().trim())
        editor.putString("Valor",tv_intValorProd2.text.toString().trim())
        editor.putString("CantidadProducto",Et_ropacantidad.text.toString().trim())
        editor.apply()
        Toast.makeText(requireContext(),"registro exitoso", Toast.LENGTH_LONG).show()
    }
    private fun guardardatosHogar(){
        val editor = sharedPreferences3.edit()

        editor.putString("nombreproducto",tv_titulohogar.text.toString().trim())
        editor.putString("cantidadDisponible",tv_cantidaddisponibleHogar.text.toString().trim())
        editor.putString("Valor",tv_intValorProd3.text.toString().trim())
        editor.putString("CantidadProducto",Ethogarcantidad.text.toString().trim())
        editor.apply()

        Toast.makeText(requireContext(),"registro exitoso", Toast.LENGTH_LONG).show()
    }
    private fun guardardatosElectronica(){
        val editor = sharedPreferences4.edit()
        editor.putString("nombreproducto",tv_tituloElec.text.toString().trim())
        editor.putString("cantidadDisponible",tv_cantidaddisponiblePortatil.text.toString().trim())
        editor.putString("Valor",tv_intValorProd4.text.toString().trim())
        editor.putString("CantidadProducto",Et_portatilcantidad.text.toString().trim())
        editor.apply()
        Toast.makeText(requireContext(),"registro exitoso", Toast.LENGTH_LONG).show()
    }

    private fun guardardatosAccesorio(){
        val editor = sharedPreferences5.edit()
        editor.putString("nombreproducto",tv_tituloAccesorio.text.toString().trim())
        editor.putString("cantidadDisponible",tv_cantidaddisponibleAccesorio.text.toString().trim())
        editor.putString("Valor",tv_intValorProd5.text.toString().trim())
        editor.putString("CantidadProducto",Et_accesoriocantidad.text.toString().trim())
        editor.apply()
        Toast.makeText(requireContext(),"registro exitoso", Toast.LENGTH_LONG).show()
    }


}