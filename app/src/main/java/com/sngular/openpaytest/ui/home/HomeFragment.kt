package com.sngular.openpaytest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.sngular.openpaytest.databinding.FragmentHomeBinding
import com.sngular.openpaytest.ui.utils.viewBinding
import kotlinx.coroutines.launch
import com.sngular.domain.common.Result
import com.sngular.openpaytest.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::inflate)
    private val viewModel by viewModels<HomeViewModel>()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.uiState.collect{
                when(it){
                    is Result.Loading -> {

                    }
                    is Result.Success -> {

                    }
                    is Result.Error -> {

                    }
                }
            }
        }
    }
}