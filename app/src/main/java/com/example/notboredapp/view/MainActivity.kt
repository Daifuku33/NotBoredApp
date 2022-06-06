package com.example.notboredapp.view

import android.content.Intent
import android.os.Bundle
import android.text.TextWatcher
import android.text.Editable
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.notboredapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startButton.isEnabled = false

        //esta funcion deberia estar ligada al texto de terminos y condiciones
        binding.termsAndConditions.setOnClickListener{
            val intent = Intent(this, TermsAndConditions::class.java)
            startActivity(intent)
        }

        binding.startButton.setOnClickListener{
            val intent = Intent(this, Activities::class.java)
            startActivity(intent)
        }

        setListeners()
        setObservers()
    }

    //Listeners ve cambios en la vista
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

    //Observer valida cambios en el Viewmodel
    private fun setObservers(){
        viewModel.blockbutton.observe(this){value ->
            binding.startButton.isEnabled = value
        }
    }
}