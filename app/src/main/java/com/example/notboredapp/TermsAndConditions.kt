package com.example.notboredapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.notboredapp.databinding.TermsAndConditionsBinding

class TermsAndConditions : AppCompatActivity() {

    private lateinit var binding: TermsAndConditionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TermsAndConditionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.xButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}