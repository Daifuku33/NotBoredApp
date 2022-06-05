package com.example.notboredapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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

        //probando nueva vista
        binding.RandomButton.setOnClickListener{
            val intent = Intent(this, Suggestion::class.java)
            startActivity(intent)
        }

        binding.list.layoutManager = LinearLayoutManager(this)

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