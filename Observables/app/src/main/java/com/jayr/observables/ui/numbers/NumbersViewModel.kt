package com.jayr.observables.ui.numbers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumbersViewModel : ViewModel() {
    private val _scoreReached = MutableLiveData<Int>()
    val scoreReached: LiveData<Int>
        get() = _scoreReached

    init {
        _scoreReached.value = 0
    }

}
