package com.sngular.domain.repository

import androidx.paging.PagingData
import com.sngular.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import com.sngular.domain.state.Result
import kotlinx.coroutines.CoroutineScope

interface MoviesRepository {
    val popularMovies: Flow<PagingData<Movie>>

    val topRatedMovies: Flow<PagingData<Movie>>

    val suggestedMovies: Flow<PagingData<Movie>>

}