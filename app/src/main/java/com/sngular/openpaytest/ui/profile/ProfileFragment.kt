package com.sngular.openpaytest.ui.profile

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.GridLayoutManager
import com.sngular.domain.state.Result
import com.sngular.openpaytest.R
import com.sngular.openpaytest.databinding.FragmentProfileBinding
import com.sngular.openpaytest.ui.movies.adapter.MoviesAdapter
import com.sngular.openpaytest.ui.profile.adapter.PeopleImageAdapter
import com.sngular.openpaytest.ui.utils.GlideHelper
import com.sngular.openpaytest.ui.utils.urlPost
import com.sngular.openpaytest.ui.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val viewModel by viewModels<ProfileViewModel>()
    private val adapter = PeopleImageAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        setupUI()
    }

    private fun setupUI(){
        binding.recyclerView.layoutManager = GridLayoutManager(context, 1,  GridLayoutManager.HORIZONTAL, false)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.setHasFixedSize(true)
    }

    private fun setupObserver(){
        lifecycleScope.launch{
            viewModel.uiState.collect{  result ->
                when(result){
                    is Result.Loading -> {
                        val result = result.data
                        Log.e("", "")
                    }
                    is Result.Success -> {
                        binding.model = result.data
                        result.data?.profilePath?.let {
                            GlideHelper.invoke(it.urlPost(), binding.imageView)
                        }

                        result.data?.peopleImages?.let {
                            adapter.submitData(PagingData.from(it))
                        }

                    }
                    is Result.Error -> {
                        Log.e("", "")
                    }
                }
            }
        }
    }
}