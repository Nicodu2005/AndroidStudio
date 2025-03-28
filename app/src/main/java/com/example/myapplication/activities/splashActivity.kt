package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R


class SplashActivity : AppCompatActivity (){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        },3000)


    }
    override fun onStart() {
        super.onStart()
        Log.d("Activity splash", "esta en estado on start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity splash", "esta en estado onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Activity splash", "esta en estado onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Activity splash", "esta en estado onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity splash", "esta en estado onDestroy")

    }

}