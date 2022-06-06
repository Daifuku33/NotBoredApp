package com.example.notboredapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notboredapp.databinding.ActivitiesItemLayoutBinding
import com.example.notboredapp.models.Activity

class ActivityAdapter: RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder>() {

    private lateinit var activities: List<Activity>

    fun setActivities(newActivities: List<Activity>) {
        this.activities = newActivities
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivitiesItemLayoutBinding.inflate(layoutInflater,parent,false)
        return ActivityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.bind(this.activities[position])
    }

    override fun getItemCount(): Int {
        return this.activities.size
    }

    class ActivityViewHolder(
        private val binding: ActivitiesItemLayoutBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(activity: Activity) {
            this.binding.title.text = activity.category
            //this.binding.selectButton =
        }
    }
}
