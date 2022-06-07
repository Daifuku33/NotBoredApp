package com.example.notboredapp.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notboredapp.Utils
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

        binding.list.layoutManager = LinearLayoutManager(this)
        viewModel.getActivities()

        val participants = this.intent.extras?.getInt(Utils.participantsLabel)
        viewModel.activities.observe(this) { value ->
            if (value != null) {
                val adapter = ActivityAdapter(object: ActivityAdapter.ActivityListener{
                    override fun onSelect(activityName: String) {
                        val intent = Intent(this@Activities , Suggestion::class.java)
                        intent.putExtra(Utils.participantsLabel,1)
                        intent.putExtra(Utils.typeLabel, activityName.lowercase())
                        startActivity(intent)
                    }
                })
                binding.list.adapter = adapter
                adapter.setActivities(value)
            }
        }

        setListeners(participants ?: 0)
        //setObservers()
    }

    private fun setListeners(participants : Int){
        binding.RandomButton.setOnClickListener{
            val intent = Intent(this, Suggestion::class.java)
            intent.putExtra(Utils.participantsLabel,participants)
            intent.putExtra(Utils.typeLabel, "")
            startActivity(intent)
        }
    }
}