package com.sngular.data.local.datasource

import com.sngular.data.local.dao.MovieDao
import com.sngular.data.remote.dto.MovieDto
import com.sngular.data.remote.mapper.MovieMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.sngular.domain.state.Result
import com.sngular.domain.datasource.local.MoviesLocalDatasource
import com.sngular.domain.model.Movie

class MoviesLocalDatasourceImpl @Inject constructor(
    private val dao: MovieDao,
    private val mapper: MovieMapper
) : MoviesLocalDatasource{
    override suspend fun getAll(size: Int): List<Movie> {
       return dao.getAll(size).map { mapper.entityToModel(it) }
    }

    override suspend fun insertAll(movies: List<Movie>) {
        dao.insertAll(movies.map { mapper.modelToEntity(it) })
    }

    override suspend fun deleteAll(movies: List<Movie>) {
        dao.deleteAll(movies.map { mapper.modelToEntity(it) })
    }
}