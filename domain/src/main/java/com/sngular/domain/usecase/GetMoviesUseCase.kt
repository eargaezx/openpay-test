package com.sngular.domain.usecase

import androidx.paging.PagingData
import com.sngular.domain.model.Movie
import com.sngular.domain.model.MovieCategory
import com.sngular.domain.repository.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
){
    operator fun invoke(category: MovieCategory):  Flow<PagingData<Movie>> {
        return when(category){
            MovieCategory.Popular -> repository.popularMovies.flowOn(dispatcher)
            MovieCategory.TopRated -> repository.topRatedMovies.flowOn(dispatcher)
            MovieCategory.Suggested -> repository.suggestedMovies.flowOn(dispatcher)
        }
    }
}