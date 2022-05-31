package com.example.notboredapp

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val NUM_REGEX = "^[0-9]+\$"
    val input: Int = 0

    fun numberVerification(input: Int) : Boolean{
        val result = NUM_REGEX.toRegex().matches(input.toString())
        return result
    }



}