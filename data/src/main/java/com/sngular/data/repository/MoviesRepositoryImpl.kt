package com.sngular.data.repository

import com.sngular.domain.datasource.local.MoviesLocalDatasource
import com.sngular.domain.datasource.remote.MoviesRemoteDatasource
import com.sngular.domain.model.Movie
import com.sngular.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.sngular.domain.common.Result

class MoviesRepositoryImpl @Inject constructor(
    private val localDataSource: MoviesLocalDatasource,
    private val remoteDataSource: MoviesRemoteDatasource
): MoviesRepository {
    override fun getAll(): Flow<Result<List<Movie>>> {
        return remoteDataSource.getAll()
    }
}