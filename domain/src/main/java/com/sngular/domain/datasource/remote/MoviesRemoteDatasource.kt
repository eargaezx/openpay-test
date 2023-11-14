package com.sngular.domain.datasource.remote

import kotlinx.coroutines.flow.Flow
import com.sngular.domain.state.Result
import com.sngular.domain.model.Movie

interface MoviesRemoteDatasource {
    suspend fun getAll(page: Int): Result<List<Movie>>
    suspend fun getPopular(page: Int): Result<List<Movie>>

    suspend fun getTopRated(page: Int): Result<List<Movie>>

    suspend fun getSuggestedovies(page: Int): Result<List<Movie>>

}