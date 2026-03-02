package com.example.lotteryrandom

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lotteryrandom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lotterlandinglogin.setOnClickListener {
            // Check if the EditText is empty using a standard 'if' statement
            if (binding.lotterlandingemailaddress.text.isEmpty()) {
                // If it's empty, show a Toast message
                Toast.makeText(this, "Please enter your email.", Toast.LENGTH_SHORT).show()
            } else {
                // If it's not empty, proceed to the next activity
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("username", binding.lotterlandingemailaddress.text.toString())
                startActivity(intent)
            }
        }
    }
}

