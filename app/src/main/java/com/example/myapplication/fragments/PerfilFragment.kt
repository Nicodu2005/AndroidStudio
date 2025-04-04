package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R

class PerfilFragment:Fragment() {

     private lateinit var btneditar: Button

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
        View? {
            val view = inflater.inflate(R.layout.fragment_perfil , container, false)

            btneditar=view.findViewById(R.id.BtnEditarInfo)

            btneditar.setOnClickListener{
                findNavController().navigate(R.id.editarFragment)
            }
            return view
        }


}