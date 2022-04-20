package com.jayr.observables.ui.numbers

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jayr.observables.R
import com.jayr.observables.databinding.NumbersFragmentBinding

class NumbersFragment : Fragment() {

    companion object {
        fun newInstance() = NumbersFragment()
    }

    private lateinit var viewModel: NumbersViewModel
    private  lateinit var binding : NumbersFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        Setting up View Binding
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.numbers_fragment,
            container,
            false
                  )

        viewModel = ViewModelProvider(this).get(NumbersViewModel::class.java)
        return binding.root
    }
}