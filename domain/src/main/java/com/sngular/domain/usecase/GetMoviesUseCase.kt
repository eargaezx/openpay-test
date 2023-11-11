package com.sngular.domain.usecase

import com.sngular.domain.model.Movie
import com.sngular.domain.repository.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import com.sngular.domain.common.Result
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
){
     operator fun invoke(): Flow<Result<List<Movie>>> {
        return repository.getAll().flowOn(dispatcher)
    }
}