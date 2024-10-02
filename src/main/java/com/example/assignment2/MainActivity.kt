package com.example.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get the button using the id set on the activity main/UI
        val btnStart= findViewById<Button>(R.id.btnStart)
        // add a code to the button that happens when it is clicked
        btnStart.setOnClickListener {
            // create the explicit intent
            val intent = Intent(this, MainActivity2::class.java)
            // start the activity
            startActivity(intent)
        }
    }
}