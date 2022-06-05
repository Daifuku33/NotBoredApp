package com.example.notboredapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notboredapp.databinding.SuggestionBinding

class Suggestion : AppCompatActivity() {

    private lateinit var binding: SuggestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SuggestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tryAnotherButton.setOnClickListener {
            Toast.makeText(this, "Try another apretado", Toast.LENGTH_LONG).show()
        }

        binding.backButton.setOnClickListener{
            val intent = Intent(this, Activities::class.java)
            startActivity(intent)
        }
    }
}