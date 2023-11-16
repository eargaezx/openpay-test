package com.sngular.openpaytest.ui.movies

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import com.sngular.domain.model.Movie
import com.sngular.domain.model.MovieCategory
import com.sngular.openpaytest.R
import com.sngular.openpaytest.databinding.FragmentHomeBinding
import com.sngular.openpaytest.ui.movies.adapter.MoviesAdapter
import kotlinx.coroutines.launch
import com.sngular.openpaytest.ui.utils.fetchMoviesAdapter
import com.sngular.openpaytest.ui.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel by viewModels<HomeViewModel>()

    private var popularMoviesAdapter = MoviesAdapter()
    private var topMoviesAdapter = MoviesAdapter()
    private var suggestedMoviesAdapter = MoviesAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        popularMoviesAdapter = binding.rvPopularMovies.fetchMoviesAdapter()
        topMoviesAdapter = binding.rvTopratedMovies.fetchMoviesAdapter()
        suggestedMoviesAdapter = binding.rvSuggestedMovies.fetchMoviesAdapter()
    }


    private fun setupObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.popularMovies.collect { pagingData ->
                loadRecyclerViewData(MovieCategory.Popular, pagingData)
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.topRatedMovies.collect { pagingData ->
                loadRecyclerViewData(MovieCategory.TopRated, pagingData)
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.suggestedMovies.collect { pagingData ->
                loadRecyclerViewData(MovieCategory.Suggested, pagingData)
            }
        }
    }

    private suspend fun loadRecyclerViewData(category: MovieCategory, data: PagingData<Movie>) {
        binding.apply {
            when (category) {
                MovieCategory.Popular -> popularMoviesAdapter.submitData(data)
                MovieCategory.TopRated -> topMoviesAdapter.submitData(data)
                MovieCategory.Suggested -> suggestedMoviesAdapter.submitData(data)
            }
        }
    }
}