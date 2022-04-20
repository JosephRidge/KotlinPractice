package com.jayr.observables.ui.numbers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NumbersViewModelFactory(private val finalScore: Int) : ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NumbersViewModel::class.java)) {
            return NumbersViewModel(finalScore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }



}