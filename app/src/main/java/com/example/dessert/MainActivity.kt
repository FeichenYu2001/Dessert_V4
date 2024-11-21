package com.example.dessert

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Button to navigate to DessertMenuActivity
        val startOrderButton: Button = findViewById(R.id.startOrderButton)
        startOrderButton.setOnClickListener {
            val intent = Intent(this, DessertMenuActivity::class.java)
            startActivity(intent)
        }
    }
}
