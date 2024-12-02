package com.example.dessert

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class DessertMenuActivity : AppCompatActivity() {

    // Variables for tracking the total amount and quantity
    private var totalAmount = 0.0

    // Price for each dessert
    private val dessertPrices = listOf(5.0, 3.5, 7.0)

    // Views for updating quantities and total amount
    private lateinit var dessert1QuantitySpinner: Spinner
    private lateinit var dessert2QuantitySpinner: Spinner
    private lateinit var dessert3QuantitySpinner: Spinner
    private lateinit var totalAmountTextView: TextView
    private lateinit var totalQuantityTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dessert_menu)

        // References to dessert images and names
        val dessert1Image: ImageView = findViewById(R.id.dessert1)
        val dessert1Name: TextView = findViewById(R.id.dessert1Name)

        val dessert2Image: ImageView = findViewById(R.id.dessert2)
        val dessert2Name: TextView = findViewById(R.id.dessert2Name)

        val dessert3Image: ImageView = findViewById(R.id.dessert3)
        val dessert3Name: TextView = findViewById(R.id.dessert3Name)

        // Set click listeners to navigate to the detailed page
        dessert1Image.setOnClickListener {
            navigateToDetail(R.string.dessert1, R.string.dessert1, R.drawable.dessert1)
        }
        dessert1Name.setOnClickListener {
            navigateToDetail(R.string.dessert1, R.string.dessert1, R.drawable.dessert1)
        }

        dessert2Image.setOnClickListener {
            navigateToDetail(R.string.dessert2, R.string.dessert2, R.drawable.dessert2)
        }
        dessert2Name.setOnClickListener {
            navigateToDetail(R.string.dessert2, R.string.dessert2, R.drawable.dessert2)
        }

        dessert3Image.setOnClickListener {
            navigateToDetail(R.string.dessert3, R.string.dessert3, R.drawable.dessert3)
        }
        dessert3Name.setOnClickListener {
            navigateToDetail(R.string.dessert3, R.string.dessert3, R.drawable.dessert3)
        }

        // Initialize the views
        dessert1QuantitySpinner = findViewById(R.id.quantityDessert1Spinner)
        dessert2QuantitySpinner = findViewById(R.id.quantityDessert2Spinner)
        dessert3QuantitySpinner = findViewById(R.id.quantityDessert3Spinner)
        totalAmountTextView = findViewById(R.id.totalAmount)
        totalQuantityTextView = findViewById(R.id.totalQuantity)

        // Initialize Spinners with quantities (1 to 10 for simplicity)
        val quantityOptions = (0..10).map { it.toString() }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, quantityOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set the adapter to each spinner
        dessert1QuantitySpinner.adapter = adapter
        dessert2QuantitySpinner.adapter = adapter
        dessert3QuantitySpinner.adapter = adapter

        // Initialize button for adding to the order
        val addToOrderButton: Button = findViewById(R.id.addToOrderButton)

        // Set button click listener
        addToOrderButton.setOnClickListener {
            // Get the selected quantities from each spinner
            val dessert1Quantity = dessert1QuantitySpinner.selectedItem.toString().toInt()
            val dessert2Quantity = dessert2QuantitySpinner.selectedItem.toString().toInt()
            val dessert3Quantity = dessert3QuantitySpinner.selectedItem.toString().toInt()

            // Calculate the total amount and total quantity
            val totalQuantity = dessert1Quantity + dessert2Quantity + dessert3Quantity
            totalAmount = (dessert1Quantity * dessertPrices[0]) +
                    (dessert2Quantity * dessertPrices[1]) +
                    (dessert3Quantity * dessertPrices[2])

            // Update the UI with total amount and quantity
            totalAmountTextView.text = "Total Amount: $${"%.2f".format(totalAmount)}"
            totalQuantityTextView.text = "Total Quantity: $totalQuantity"

            // Optionally, show a toast confirming the order
            Toast.makeText(this, "Order added successfully!", Toast.LENGTH_SHORT).show()
        }

        // BottomNavigationView setup
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        // Set listener for navigation item selection
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    // Navigate to MainActivity when Home is selected
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Finish the current activity to avoid going back to it
                    true
                }
                R.id.profile -> {
                    val intent = Intent(this, DessertMenuActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.settings -> {
                    // Handle Settings item selection (if needed)
                    true
                }
                else -> false
            }
        }
    }

    private fun navigateToDetail(
        dessertNameResId: Int,
        dessertPriceResId: Int,
        dessertImageResId: Int
    ) {
        val intent = Intent(this, DessertDetailActivity::class.java)
        intent.putExtra("DESSERT_NAME_RES_ID", dessertNameResId)
        intent.putExtra("DESSERT_PRICE_RES_ID", dessertPriceResId)
        intent.putExtra("DESSERT_IMAGE_RES_ID", dessertImageResId)
        startActivity(intent)
    }
}





