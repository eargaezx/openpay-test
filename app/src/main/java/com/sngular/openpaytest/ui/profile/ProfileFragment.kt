package com.sngular.openpaytest.ui.profile

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.sngular.domain.state.Result
import com.sngular.openpaytest.R
import com.sngular.openpaytest.databinding.FragmentProfileBinding
import com.sngular.openpaytest.ui.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val viewModel by viewModels<ProfileViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
    }

    private fun setupObserver(){
        lifecycleScope.launch{
            viewModel?.uiState?.collect{  result ->
                when(result){
                    is Result.Loading -> {
                        val result = result.data
                        Log.e("", "")
                    }
                    is Result.Success -> {
                        Log.e("", "")
                    }
                    is Result.Error -> {
                        Log.e("", "")
                    }
                }
            }
        }
    }
}