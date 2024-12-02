package com.example.dessert

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
//import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

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
        //val backButton: Button = findViewById(R.id.backButton)

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
        /*
        backButton.setOnClickListener {
            finish() // Go back to the previous activity
        }*/

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
        val detailLayout: LinearLayout = findViewById(R.id.detailXML)
        // setup on touch listener
        detailLayout.setOnTouchListener { _, _ ->
            finish()
            true
        }
        val imageView: ImageView = dessertImageView
        // get org place
        val originalX = imageView.x
        val originalY = imageView.y
        println(originalY)
        println(originalX)
        // setup touch listener
        imageView.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // org place
                    v.tag = Pair(event.rawX, event.rawY)
                }
                MotionEvent.ACTION_MOVE -> {
                    // get finger
                    val initialTouch = v.tag as Pair<Float, Float>
                    val deltaX = event.rawX - initialTouch.first
                    val deltaY = event.rawY - initialTouch.second

                    // refresh
                    v.x = v.x + deltaX
                    v.y = v.y + deltaY

                    // refresh
                    v.tag = Pair(event.rawX, event.rawY)
                }

                MotionEvent.ACTION_UP -> {
                    // goback
                    v.animate().x(originalX).y(originalY).setDuration(300).start()
                }
            }
            true // end
        }
    }
}

