package com.example.finaluritesting

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Menu : AppCompatActivity() {


    private lateinit var buttonCars : Button
    private lateinit var buttonHelp: Button
    private lateinit var buttonProfile: Button
    private lateinit var buttonAboutUs : Button



    private lateinit var buttonLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        init()
        registerListeners()
        profileListeners()
        goToGarage()

    }

    private fun init() {
        buttonLogout = findViewById(R.id.button12)
        buttonCars = findViewById(R.id.button7)
        buttonProfile = findViewById(R.id.button9)
    }


    private fun registerListeners() {
        buttonLogout.setOnClickListener() {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun profileListeners() {
        buttonProfile.setOnClickListener() {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }

    private fun goToGarage() {
        buttonCars.setOnClickListener() {
            val intent = Intent(this, Testing::class.java)
            startActivity(intent)
        }
    }



}