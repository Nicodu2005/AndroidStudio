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
        val view = inflater.inflate(R.layout.fragment_producto, container, false)
        sharedPreferences1 = requireActivity().getSharedPreferences("dataBalon", Context.MODE_PRIVATE)
        sharedPreferences2 = requireActivity().getSharedPreferences("dataropa", Context.MODE_PRIVATE)
        sharedPreferences3 = requireActivity().getSharedPreferences("datahogar", Context.MODE_PRIVATE)
        sharedPreferences4 = requireActivity().getSharedPreferences("dataelectronica", Context.MODE_PRIVATE)
        sharedPreferences5= requireActivity().getSharedPreferences("dataaccesorios", Context.MODE_PRIVATE)

        tv_titulobalon_products = view.findViewById(R.id.titulobalon)
        tv_cantidaddisponiblebalon = view.findViewById(R.id.intValorSrock)
        tv_intValorProd1 = view.findViewById(R.id.valorbalon)
        Et_baloncantidad = view.findViewById(R.id.baloncantidad)
        btnAgregarbalon = view.findViewById(R.id.BtnagregarProd1)
        btnAgregarbalon.setOnClickListener{
            guardardatos()
        }

        tv_tituloropa = view.findViewById(R.id.tituloropa)
        tv_cantidaddisponibleropa = view.findViewById(R.id.intValorRopaStock)
        tv_intValorProd2 = view.findViewById(R.id.valorropa)
        Et_ropacantidad = view.findViewById(R.id.ropacantidad)
        btnAgregarropa = view.findViewById(R.id.Btnagregarprod2)
        btnAgregarropa.setOnClickListener{
            guardardatosropa()
        }

        tv_titulohogar = view.findViewById(R.id.titulohogarProductos)
        tv_cantidaddisponibleHogar = view.findViewById(R.id.intValorStock)
        tv_intValorProd3 = view.findViewById(R.id.valorhogarpro)
        Ethogarcantidad = view.findViewById(R.id.hogarcantidadEdit)
        btnAgregarhogar = view.findViewById(R.id.Btnagregarhogar)
        btnAgregarhogar.setOnClickListener{
            guardardatosHogar()
        }

        tv_tituloElec = view.findViewById(R.id.titulotechPortatil)
        tv_cantidaddisponiblePortatil = view.findViewById(R.id.valorStockPortatil)
        tv_intValorProd4 = view.findViewById(R.id.Valorprod_tech)
        Et_portatilcantidad = view.findViewById(R.id.techcantidad)
        btnAgregarelec = view.findViewById(R.id.Btnagregartech)
        btnAgregarelec.setOnClickListener{
            guardardatosElectronica()
        }

        tv_tituloAccesorio = view.findViewById(R.id.tituloAcces)
        tv_cantidaddisponibleAccesorio = view.findViewById(R.id.valorStockGafas)
        tv_intValorProd5 = view.findViewById(R.id.valorgafas)
        Et_accesoriocantidad = view.findViewById(R.id.gafascantidad)
        btnAgregaraccesorios = view.findViewById(R.id.Btnagregarprod5)
        btnAgregaraccesorios.setOnClickListener{
            guardardatosAccesorio()
        }

        return view

    }
    private fun guardardatos(){


        val editorBalon = sharedPreferences1.edit()

        editorBalon.putString("nombreproducto",tv_titulobalon_products.text.toString().trim())
        editorBalon.putString("cantidadDisponible",tv_cantidaddisponiblebalon.text.toString().trim())
        editorBalon.putString("Valor",tv_intValorProd1.text.toString().trim())
        editorBalon.putString("CantidadProducto",Et_baloncantidad.text.toString().trim())
        if (Et_baloncantidad.text.toString().trim().isEmpty()) {
            Toast.makeText(requireContext(), "indique la cantidad", Toast.LENGTH_SHORT).show()
        }else{
            editorBalon.apply()
            Toast.makeText(requireContext(), getString(R.string.productos_agregado), Toast.LENGTH_LONG).show()
        }

    }
    private fun guardardatosropa(){
        val editorropa = sharedPreferences2.edit()
        editorropa.putString("nombreproducto",tv_tituloropa.text.toString().trim())
        editorropa.putString("cantidadDisponible",tv_cantidaddisponibleropa.text.toString().trim())
        editorropa.putString("Valor",tv_intValorProd2.text.toString().trim())
        editorropa.putString("CantidadProducto",Et_ropacantidad.text.toString().trim())
        if (Et_ropacantidad.text.toString().trim().isEmpty()) {
        Toast.makeText(requireContext(), "indique la cantidad", Toast.LENGTH_SHORT).show()
    }else{
        editorropa.apply()
        Toast.makeText(requireContext(), getString(R.string.productos_agregado), Toast.LENGTH_LONG).show()
    }}
    private fun guardardatosHogar(){
        val editorhogar = sharedPreferences3.edit()

        editorhogar.putString("nombreproducto",tv_titulohogar.text.toString().trim())
        editorhogar.putString("cantidadDisponible",tv_cantidaddisponibleHogar.text.toString().trim())
        editorhogar.putString("Valor",tv_intValorProd3.text.toString().trim())
        editorhogar.putString("CantidadProducto",Ethogarcantidad.text.toString().trim())
        if (Ethogarcantidad.text.toString().trim().isEmpty()) {
        Toast.makeText(requireContext(), "indique la cantidad", Toast.LENGTH_SHORT).show()
    }else{
        editorhogar.apply()
        Toast.makeText(requireContext(), getString(R.string.productos_agregado), Toast.LENGTH_LONG).show()
    }
    }
    private fun guardardatosElectronica(){
        val editortech = sharedPreferences4.edit()
        editortech.putString("nombreproducto",tv_tituloElec.text.toString().trim())
        editortech.putString("cantidadDisponible",tv_cantidaddisponiblePortatil.text.toString().trim())
        editortech.putString("Valor",tv_intValorProd4.text.toString().trim())
        editortech.putString("CantidadProducto",Et_portatilcantidad.text.toString().trim())
        if (Et_portatilcantidad.text.toString().trim().isEmpty()) {
        Toast.makeText(requireContext(), "indique la cantidad", Toast.LENGTH_SHORT).show()
    }else{
        editortech.apply()
        Toast.makeText(requireContext(), getString(R.string.productos_agregado), Toast.LENGTH_LONG).show()
    }}

    private fun guardardatosAccesorio(){
        val editoracces = sharedPreferences5.edit()
        editoracces.putString("nombreproducto",tv_tituloAccesorio.text.toString().trim())
        editoracces.putString("Valor",tv_intValorProd5.text.toString().trim())
        editoracces.putString("CantidadProducto",Et_accesoriocantidad.text.toString().trim())

        if (Et_accesoriocantidad.text.toString().trim().isEmpty()) {
        Toast.makeText(requireContext(), "indique la cantidad", Toast.LENGTH_SHORT).show()
    }else{
        editoracces.apply()
        Toast.makeText(requireContext(), getString(R.string.productos_agregado), Toast.LENGTH_LONG).show()
    }
    }


}