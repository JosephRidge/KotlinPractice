package com.jayr.vmtest.ui.finalcount

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jayr.vmtest.R
import com.jayr.vmtest.databinding.FinalcountFragmentBinding

class Finalcount : Fragment() {

    companion object {
        fun newInstance() = Finalcount()
    }

    private lateinit var viewModel: FinalcountViewModel
    private lateinit var binding: FinalcountFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.finalcount_fragment,
            container, false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FinalcountViewModel::class.java)
        // TODO: Use the ViewModel
    }

}