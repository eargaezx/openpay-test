package com.sngular.domain.datasource.remote

import kotlinx.coroutines.flow.Flow
import com.sngular.domain.common.Result
import com.sngular.domain.model.Movie

interface MoviesRemoteDatasource {
    fun getAll(): Flow<Result<List<Movie>>>

}