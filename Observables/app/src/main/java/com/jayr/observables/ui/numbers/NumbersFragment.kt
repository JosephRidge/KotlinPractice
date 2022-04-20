package com.jayr.observables.ui.numbers

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat.Token.fromBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.Person.fromBundle
import androidx.databinding.DataBindingUtil
import androidx.media.AudioAttributesCompat.fromBundle
import com.jayr.observables.R
import com.jayr.observables.databinding.NumbersFragmentBinding

class NumbersFragment : Fragment() {

    companion object {
        fun newInstance() = NumbersFragment()
    }

    private lateinit var viewModel: NumbersViewModel
    private  lateinit var binding : NumbersFragmentBinding
    private lateinit var viewModelFactory: NumbersViewModelFactory

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

        viewModelFactory = NumbersViewModelFactory(Numbers)
        viewModel = ViewModelProvider(this).get(NumbersViewModel::class.java)
//         viewModelFactory = NumbersViewModelFactory(NumbersFra.fromBundle(requireArguments()).score)
//        viewModelFactory = NumbersViewModelFactory(Numbers)

        return binding.root
    }
}