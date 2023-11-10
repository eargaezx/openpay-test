package com.sngular.domain.datasource.local

import com.sngular.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesLocalDatasource {
    fun getAll(): Flow<Result<List<Movie>>>

}