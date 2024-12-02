
package com.example.dessert

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Get reference to the TextView (the text you want to animate)
        val mainText: TextView = findViewById(R.id.mainText)

        // Load the slide-in animation from the right
        val slideInRight = AnimationUtils.loadAnimation(this, R.anim.slide_in_right)

        // Start the slide-in animation on the TextView
        mainText.startAnimation(slideInRight)
        // Button to navigate to DessertMenuActivity
        val startOrderButton: Button = findViewById(R.id.startOrderButton)
        startOrderButton.setOnClickListener {
            // Create an Intent to navigate to DessertMenuActivity
            val intent = Intent(this, DessertMenuActivity::class.java)
            startActivity(intent)
        }
    }
}
