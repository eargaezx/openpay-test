package com.sngular.openpaytest.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sngular.domain.model.Movie
import com.sngular.domain.usecase.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.sngular.domain.common.Result
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GetMoviesUseCase
) : ViewModel() {
    // Backing property to avoid state updates from other classes
    private val _uiState = MutableStateFlow<Result<List<Movie>>>(Result.Success(emptyList()))
    // The UI collects from this StateFlow to get its state updates
    val uiState: StateFlow<Result<List<Movie>>> = _uiState

    init {
        getAllMovies()
    }

    fun getAllMovies(){
        useCase()
            .onEach {
                val movies = it.data
                Log.d("onEach", "movies")
            }
            .catch {
                val throwable = it
                Log.d("catch", throwable.toString())
            }
            .launchIn(viewModelScope)
    }
}