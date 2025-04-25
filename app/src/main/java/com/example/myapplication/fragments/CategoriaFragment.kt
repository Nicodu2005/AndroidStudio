package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.myapplication.R

class CategoriaFragment : Fragment() {

    private lateinit var ropa: ImageView
    private lateinit var deportes: ImageView
    private lateinit var electronica: ImageView
    private lateinit var accesorios: ImageView
    private lateinit var hogar: ImageView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_categoria, container, false)
        return view
    }
}