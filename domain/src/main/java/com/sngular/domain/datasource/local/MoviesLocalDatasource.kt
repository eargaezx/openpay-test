package com.sngular.domain.datasource.local

import com.sngular.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import com.sngular.domain.common.Result
interface MoviesLocalDatasource {
    fun getAll(): Flow<Result<List<Movie>>>

}