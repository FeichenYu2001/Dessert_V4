package com.example.dessert

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DessertDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dessert_detail)

        // Retrieve resource IDs from Intent
        val dessertNameResId = intent.getIntExtra("DESSERT_NAME_RES_ID", 0)
        val dessertImageResId = intent.getIntExtra("DESSERT_IMAGE_RES_ID", 0)

        // Get values from resources
        val dessertName = getString(dessertNameResId)

        // Set data to views
        val dessertNameTextView: TextView = findViewById(R.id.dessertName)
        val dessertImageView: ImageView = findViewById(R.id.dessertImage)
        val dessertIngredientTextView: TextView = findViewById(R.id.dessertIngredients)
        val backButton: Button = findViewById(R.id.backButton)


        dessertNameTextView.text = dessertName
        dessertImageView.setImageResource(dessertImageResId)

        // Set ingredients based on dessert name
        val ingredients = if (dessertNameResId == R.string.dessert1) {
            getString(R.string.ingredients_dessert1)
        } else if (dessertNameResId == R.string.dessert2) {
            getString(R.string.ingredients_dessert2)
        } else if (dessertNameResId == R.string.dessert3) {
            getString(R.string.ingredients_dessert3)
        } else {
            ""
        }
        dessertIngredientTextView.text = ingredients

        // Set back button functionality
        backButton.setOnClickListener {
            finish() // Go back to the previous activity
        }
    }
}
