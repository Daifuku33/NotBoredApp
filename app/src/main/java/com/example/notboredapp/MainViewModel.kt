package com.example.notboredapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val NUM_REGEX = "^[0-9]+\$"
    var blockbutton : MutableLiveData<Boolean> = MutableLiveData()

    fun numberVerification(input: String){
        blockbutton.value = NUM_REGEX.toRegex().matches(input)
    }
}