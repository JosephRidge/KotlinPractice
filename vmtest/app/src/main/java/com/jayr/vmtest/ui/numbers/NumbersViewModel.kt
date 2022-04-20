package com.jayr.vmtest.ui.numbers

import android.util.Log
import androidx.lifecycle.ViewModel

class NumbersViewModel : ViewModel() {
   var leftNum = 0
   var rightNum = 0

    init {
        Log.i("NumbersViewsModel", "Num View Model Initiated")
    }

    fun addOneNumber(){

        leftNum += 1
    }

    fun addTwoNumbers(){
        rightNum += 2
    }
}