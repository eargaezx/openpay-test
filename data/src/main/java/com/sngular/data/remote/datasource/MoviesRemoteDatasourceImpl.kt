package com.sngular.data.remote.datasource

import com.sngular.data.remote.api.StatusCode
import com.sngular.data.remote.api.ApiService
import com.sngular.data.remote.mapper.MovieMapper
import com.sngular.domain.datasource.remote.MoviesRemoteDatasource
import javax.inject.Inject
import com.sngular.domain.state.Result
import com.sngular.domain.model.Movie


class MoviesRemoteDatasourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: MovieMapper
) : MoviesRemoteDatasource {

    override suspend fun getAll(page: Int): Result<List<Movie>>{
        return try {
            val response = apiService.getAllMovies(page, "en-US")
            when (response.code()) {
                StatusCode.SUCCESS.code -> {
                    Result.Success(
                        response.body()!!.results!!.map {
                            mapper.dtoToModel(it)
                        }
                    )
                }

                else -> Result.Error(response.message())
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: e.toString())
        }
    }

    override suspend fun getPopular(page: Int): Result<List<Movie>>{
        return try {
            val response = apiService.getPopularMovies(page, "en-US")
            when (response.code()) {
                StatusCode.SUCCESS.code -> {
                    Result.Success(
                        response.body()!!.results!!.map {
                            mapper.dtoToModel(it)
                        }
                    )
                }

                else -> Result.Error(response.message())
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: e.toString())
        }
    }

    override suspend fun getTopRated(page: Int): Result<List<Movie>>{
        return try {
            val response = apiService.getTopMovies(page, "en-US")
            when (response.code()) {
                StatusCode.SUCCESS.code -> {
                    Result.Success(
                        response.body()!!.results!!.map {
                            mapper.dtoToModel(it)
                        }
                    )
                }

                else -> Result.Error(response.message())
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: e.toString())
        }
    }

    override suspend fun getSuggestedovies(page: Int): Result<List<Movie>>{
        return try {
            val response = apiService.getSuggestedMovies(page, "en-US")
            when (response.code()) {
                StatusCode.SUCCESS.code -> {
                    Result.Success(
                        response.body()!!.results!!.map {
                            mapper.dtoToModel(it)
                        }
                    )
                }

                else -> Result.Error(response.message())
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: e.toString())
        }
    }

}