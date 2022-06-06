package com.example.notboredapp.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val NUM_REGEX = "^[1-9][0-9]*\$"
    var blockbutton : MutableLiveData<Boolean> = MutableLiveData()

    fun numberVerification(input: String){
        blockbutton.value = NUM_REGEX.toRegex().matches(input)
        //ver si se puede incluir en REGEX
        /*if (blockbutton.value == true && input.toInt() < 1)
        {
            blockbutton.value = false
        }*/
    }
}