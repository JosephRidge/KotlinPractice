package com.jayr.vmtest.ui.numbers

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jayr.vmtest.R
import com.jayr.vmtest.databinding.NumbersFragmentBinding

class Numbers : Fragment() {

    companion object {
        fun newInstance() = Numbers()
    }

    private lateinit var viewModel: NumbersViewModel
    private lateinit var binding: NumbersFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding  = DataBindingUtil.inflate(
            inflater,
            R.layout.numbers_fragment,
            container, false
        )
        viewModel = ViewModelProvider(this).get(NumbersViewModel::class.java)
        updateRightNumText()
        updateleftNumText()
         binding.buttonAddOne.setOnClickListener {
             viewModel.addOneNumber()
             updateleftNumText()  }
         binding.buttonAddTwo.setOnClickListener {
            viewModel.addTwoNumbers()
             updateRightNumText()}

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

        fun updateleftNumText(){
            binding.leftNum.text = viewModel.leftNum.toString()
        }

        fun updateRightNumText(){
            binding.rightNum.text = viewModel.rightNum.toString()
        }



}