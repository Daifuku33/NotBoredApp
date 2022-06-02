package com.example.notboredapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.notboredapp.databinding.ActivitiesBinding

class Activities : AppCompatActivity() {

    private lateinit var binding: ActivitiesBinding

    private val viewModel : ActivityViewModel by viewModels(
        factoryProducer = { ActivitiesViewModelFactory() }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RandomButton.setOnClickListener{
            Toast.makeText(this,"Boton random apretado", Toast.LENGTH_LONG).show()
        }

        viewModel.getActivities()

        viewModel.activities.observe(this) { value ->
            if (value != null) {
                val adapter = ActivityAdapter()
                binding.list.adapter = adapter
                adapter.setActivities(value)
            }
        }
    }
}