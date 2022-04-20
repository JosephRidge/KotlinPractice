package com.jayr.observables.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
     private val _numbers = MutableLiveData<Int>()
     val number : LiveData<Int>
        get() = _numbers

    init {
        _numbers.value = 0
    }

    fun addNumber(){
       _numbers.value =  (_numbers.value)?.plus(1)
    }
}