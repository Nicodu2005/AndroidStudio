package com.example.myapplication.activities

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.myapplication.R
import com.google.android.material.navigation.NavigationView

class MainActivity: AppCompatActivity() {

    private lateinit var navController : NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var drawerLayout: androidx.drawerlayout.widget.DrawerLayout
    private lateinit var drawerToogle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*configuración de la barra de herramientas*/
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        /*navegacion de los fragments*/
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        navController=navHostFragment?.findNavController()!!

        drawerLayout=findViewById(R.id.drawer_layout)
        val navView: NavigationView =findViewById(R.id.nav_view)

        drawerToogle= ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(drawerToogle)
        drawerToogle.syncState()




    }
}