package com.example.assignment2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {
    // pet attributes
    private var petHealth = 100
    private var petHunger = 50
    private var petCleanliness = 50
    private var petHappiness = 50

    //constants for attribute changes
    private val hungerChange = 10
    private val cleanlinessChange = 10
    private val healthChange = 10
    private val hungerAfterPlay = 5
    private val cleanlinessAfterPLay = -5
    private val happinessChange = 10

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        // declare variables
        val feedBtn = findViewById<Button>(R.id.feedBtn)
        val cleanBtn = findViewById<Button>(R.id.cleanBtn)
        val playBtn = findViewById<Button>(R.id.playBtn)
        val petHungry = findViewById<EditText>(R.id.petHungry)
        val petClean = findViewById<EditText>(R.id.petClean)
        val petHappy = findViewById<EditText>(R.id.petHappy)
        val petImage = findViewById<ImageView>(R.id.petImage)
        fun animatedImageChange(imageView: ImageView, drawablesRes: Int) {
            //display intial values
            petHungry.setText(petHunger.toString())
            petClean.setText(petCleanliness.toString())
            petHappy.setText(petHappiness.toString())
            // code for when feed button is clicked
            feedBtn.setOnClickListener {
                petHunger += hungerChange
                petHealth += healthChange
                //ensure attributes stay within bounds
                petHunger = petHunger.coerceIn(0, 100)
                petHealth = petHealth.coerceIn(0, 100)
                petCleanliness = petCleanliness.coerceIn(0, 100)
                petHungry.setText(petHunger.toString())
                petClean.setText(petCleanliness.toString())
                animatedImageChange(petImage, R.drawable.eatingpuppy)
            }
            //code for when clean button is clicked
            cleanBtn.setOnClickListener {
                petCleanliness += cleanlinessChange
                petHealth += healthChange
                //ensure attributes stay within
                petCleanliness = petCleanliness.coerceIn(0, 100)
                petHealth = petHealth.coerceIn(0, 100)
                petClean.setText(petCleanliness.toString())
                animatedImageChange(petImage, R.drawable.cleanpuppy)
            }
            //code for when play button is clicked
            playBtn.setOnClickListener {
                petHunger -= hungerAfterPlay
                petCleanliness += cleanlinessAfterPLay
                petHappiness += happinessChange
                petHealth += healthChange
                //ensure attributes stay within bounds
                petHealth = petHealth.coerceIn(0, 100)
                petHunger = petHunger.coerceIn(0, 100)
                petCleanliness = petCleanliness.coerceIn(0, 100)
                petHappiness = petHappiness.coerceIn(0, 100)
                petHappy.setText(petHappiness.toString())
                petHungry.setText(petHunger.toString())
                petClean.setText(petCleanliness.toString())
                animatedImageChange(petImage, R.drawable.play)
            }
            //function for changing the images when the buttons are clicked
            fun animatedImageChange(imageView: ImageView, newImageResource: Int) {
                val animation = AlphaAnimation(0.0f, 1.0f)
                animation.duration = 500
                animation.fillAfter = true
                imageView.startAnimation(animation)
                imageView.setImageResource(newImageResource)
            }
        }
    }
}









