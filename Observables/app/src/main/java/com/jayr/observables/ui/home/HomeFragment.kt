package com.jayr.observables.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.jayr.observables.R
import com.jayr.observables.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding:HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//      Setting up the binding
        binding  = DataBindingUtil.inflate(
            inflater,
            R.layout.home_fragment,
            container,
            false)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding.addButotn.setOnClickListener {
           viewModel.addNumber()
           binding.numberText.text = viewModel.number.value.toString()
        }
        binding.numberText.text = viewModel.number.value.toString()
        viewModel.number.observe(viewLifecycleOwner, Observer {
            number ->
            if(number == 10){
                val action = HomeFragmentDirections.actionHomeFragmentToNumbersFragment()
                NavHostFragment.findNavController(this).navigate(action)
            }
        })

        return binding.root
    }


}