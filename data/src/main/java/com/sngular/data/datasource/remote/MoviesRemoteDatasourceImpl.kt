package com.sngular.data.datasource.remote

import com.sngular.data.BuildConfig
import com.sngular.data.network.StatusCode
import com.sngular.data.network.api.ApiService
import com.sngular.data.network.mapper.MovieMapper
import com.sngular.domain.datasource.remote.MoviesRemoteDatasource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.sngular.domain.common.Result
import com.sngular.domain.model.Movie


class MoviesRemoteDatasourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: MovieMapper
) : MoviesRemoteDatasource {
    override fun getAll(): Flow<Result<List<Movie>>> = flow {
        emit(Result.Loading())
        // Register listener
        try {
            val response =  apiService.getAllMovies(BuildConfig.AUTHORIZATION)
            when(response.code()){
                StatusCode.SUCCESS.code -> {
                    emit(Result.Success(
                            response.body()!!.results!!.map {
                                   mapper.mapToEntity(it)
                            }
                        ))
                }
                else ->  emit(Result.Error(response.message()))
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message ?: e.toString()))
        }
    }
}