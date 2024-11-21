package com.example.dessert

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DessertDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dessert_detail)

        // Retrieve resource IDs from Intent
        val dessertNameResId = intent.getIntExtra("DESSERT_NAME_RES_ID", 0)
        val dessertPriceResId = intent.getIntExtra("DESSERT_PRICE_RES_ID", 0)
        val dessertImageResId = intent.getIntExtra("DESSERT_IMAGE_RES_ID", 0)

        // Get values from resources
        val dessertName = getString(dessertNameResId)
        val dessertPrice = getString(dessertPriceResId)

        // Set data to views
        val dessertNameTextView: TextView = findViewById(R.id.dessertName)
        val dessertPriceTextView: TextView = findViewById(R.id.dessertPrice)
        val dessertImageView: ImageView = findViewById(R.id.dessertImage)

        dessertNameTextView.text = dessertName
        dessertPriceTextView.text = "Price: $${dessertPrice} each"
        dessertImageView.setImageResource(dessertImageResId)
    }
}
