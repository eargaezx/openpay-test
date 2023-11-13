package com.sngular.openpaytest.ui.movies

import androidx.lifecycle.ViewModel
import com.sngular.domain.model.MovieCategory
import com.sngular.domain.usecase.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GetMoviesUseCase,
) : ViewModel() {
    val popularMovies = useCase.invoke(MovieCategory.Popular)
    val topRatedMovies = useCase.invoke(MovieCategory.TopRated)
    val suggestedMovies = useCase.invoke(MovieCategory.Suggested)
}