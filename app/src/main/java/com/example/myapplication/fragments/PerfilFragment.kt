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
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R

class PerfilFragment:Fragment() {

     private lateinit var btneditar: Button

    private lateinit var getTextNombres: String
    private lateinit var getTextApellido: String
    private lateinit var getTextsemestre: String
    private lateinit var getTextPrograma: String
    private lateinit var getTextCorreo: String
    private lateinit var TextNombres: TextView
    private lateinit var TextApellido: TextView
    private lateinit var TextCorreo: TextView
    private lateinit var TextPrograma: TextView
    private lateinit var TextSemestre: TextView

    private lateinit var sharedPreference: SharedPreferences

     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
        View? {
            val view = inflater.inflate(R.layout.fragment_perfil , container, false)
         sharedPreference = requireActivity().getSharedPreferences("UserData", Context.MODE_PRIVATE)
         TextNombres = view.findViewById(R.id.nombres_perfil)
         TextApellido = view.findViewById(R.id.apellido_perfil)
         TextCorreo = view.findViewById(R.id.correo_perfil)
         TextPrograma = view.findViewById(R.id.programa_user)
         TextSemestre = view.findViewById(R.id.semestre_perfil)

         ObtenerDatos()


            return view
        }
    private fun ObtenerDatos() {


        getTextNombres = sharedPreference.getString("nombres", "Username") ?: "username";
        getTextApellido = sharedPreference.getString("apellidos", "Userlastname") ?: "Userlastname";
        getTextCorreo = sharedPreference.getString("correo", "Useremail") ?: "Useremail";
        getTextsemestre = sharedPreference.getString("semestre", "Usersemestre") ?: "Usersemestre";
        getTextPrograma = sharedPreference.getString("programa", "Userprograma") ?: "Userprograma";


        TextNombres.setText(getTextNombres)
        TextApellido.setText(getTextApellido)
        TextCorreo.setText(getTextCorreo)
        TextPrograma.setText(getTextPrograma)
        TextSemestre.setText(getTextsemestre)

    }



}