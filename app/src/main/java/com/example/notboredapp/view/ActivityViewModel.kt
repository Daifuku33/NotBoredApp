package com.example.notboredapp.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notboredapp.models.Activity
import com.example.notboredapp.data.repository.ActivitiesRepository

class ActivityViewModel( private val repository: ActivitiesRepository) : ViewModel() {

    val activities = MutableLiveData<List<Activity>>(null)

    fun getActivities(){
        activities.value = repository.getActivities()
        println(activities.value)
    }


}