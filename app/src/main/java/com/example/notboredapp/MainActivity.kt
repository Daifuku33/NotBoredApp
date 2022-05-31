package com.example.notboredapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.notboredapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel = MainViewModel()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userInput = binding.ParticipantsNumber

        //esta funcion deberia estar ligada al texto de terminos y condiciones
        binding.termsAndConditions.setOnClickListener{
            val intent = Intent(this, TermsAndConditions::class.java)
            startActivity(intent)
        }

        //setListeners()
    }

    private fun setListeners(input: Int) {
        binding.ParticipantsNumber.addTextChangedListener() {
            viewModel.numberVerification(input)
        }
    }
}