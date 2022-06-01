package com.example.notboredapp

import android.content.Intent
import android.os.Bundle
import android.text.TextWatcher
import android.text.Editable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notboredapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel = MainViewModel()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //esta funcion deberia estar ligada al texto de terminos y condiciones
        binding.termsAndConditions.setOnClickListener{
            val intent = Intent(this, TermsAndConditions::class.java)
            startActivity(intent)
        }

        binding.startButton.setOnClickListener(){
            Toast.makeText(this,"Click", Toast.LENGTH_LONG).show()
        }

        setListeners()
        setObservers()
    }

    private fun setListeners() {
        binding.ParticipantsNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence,start: Int,
                                       before: Int, count: Int) {
                viewModel.numberVerification(s.toString())
            }
        })
    }

    private fun setObservers(){
        viewModel.blockbutton.observe(this){value ->
            binding.startButton.isEnabled = value
        }
    }
}