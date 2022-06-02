package com.example.notboredapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel( private val repository: ActivitiesRepository ) : ViewModel() {

    val activities = MutableLiveData<List<Activity>>(null)

    fun getActivities(){
        activities.value = repository.getActivities()
        println(activities.value)
    }


}