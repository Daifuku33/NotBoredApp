package com.example.notboredapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notboredapp.databinding.ActivitiesBinding

class Activities : AppCompatActivity() {

    private lateinit var binding: ActivitiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RandomButton.setOnClickListener{
            Toast.makeText(this,"Boton random apretado", Toast.LENGTH_LONG).show()
        }
    }
}