package com.example.notboredapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.notboredapp.Utils
import com.example.notboredapp.databinding.SuggestionBinding

class Suggestion : AppCompatActivity() {

    private lateinit var binding: SuggestionBinding
    private val viewModel: SuggestionViewModel by viewModels(
        factoryProducer = { SuggestionModelFactory()
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SuggestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val participants = this.intent.extras?.getInt(Utils.participantsLabel) ?: 0
        val type = this.intent.extras?.getString(Utils.typeLabel) ?: ""

        setObservers()

        if(type.equals(""))
            viewModel.getRandomSuggestion(participants)
        else
            viewModel.getSuggestion(participants,type)

        binding.tryAnotherButton.setOnClickListener {
            viewModel.getRandomSuggestion(participants)
        }

        binding.backButton.setOnClickListener{
            val intent = Intent(this, Activities::class.java)
            startActivity(intent)
        }
    }

    private fun setObservers() {
        viewModel.suggestion.observe(this) { value ->
            if (value != null) {
                binding.suggestionTitle.text = value.type.uppercase()
                binding.suggestionName.text = value.activity
                binding.participantsNumber.text = value.participants.toString()
                binding.PriceNumber.text = value.price.toString()
            } else {
                binding.suggestionTitle.text = ""
                binding.suggestionName.text = ""
                binding.participantsNumber.text = ""
                binding.PriceNumber.text = ""
            }
        }

        viewModel.error.observe(this) { value ->
            if(value != null){
                Toast.makeText(this, value, Toast.LENGTH_LONG).show()
            }
        }
    }
}