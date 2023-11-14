package com.sngular.domain.datasource.local

import com.sngular.domain.model.Movie
interface MoviesLocalDatasource {
    suspend fun getAll(size: Int): List<Movie>

    suspend fun insertAll(movies: List<Movie>)

    suspend fun deleteAll(movies: List<Movie>)

}