package com.example.notboredapp.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notboredapp.data.repository.ActivitiesRepository

class ActivitiesViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val repository = ActivitiesRepository()

        //return modelClass.getConstructor(FilmsRepository::class.java).newInstance(repository)
        return ActivityViewModel(repository) as T
    }
}