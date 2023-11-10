package com.sngular.domain.repository

import com.sngular.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getAll(): Flow<Result<List<Movie>>>

}