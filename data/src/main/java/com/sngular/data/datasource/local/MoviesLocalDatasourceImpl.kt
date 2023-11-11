package com.sngular.data.datasource.local

import com.sngular.data.network.api.ApiService
import com.sngular.data.network.mapper.MovieMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.sngular.domain.common.Result
import com.sngular.domain.datasource.local.MoviesLocalDatasource
import com.sngular.domain.model.Movie

class MoviesLocalDatasourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: MovieMapper
) : MoviesLocalDatasource{
    override fun getAll(): Flow<Result<List<Movie>>> {
       return flow {
            emit(Result.Success(listOf<Movie>()))
        }
    }
}