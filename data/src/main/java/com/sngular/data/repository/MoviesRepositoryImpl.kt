package com.sngular.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.sngular.domain.model.MovieCategory
import com.sngular.data.remote.api.ApiService
import com.sngular.data.remote.mapper.MovieMapper
import com.sngular.data.remote.pagingsource.MoviesPagingSource
import com.sngular.domain.datasource.local.MoviesLocalDatasource
import com.sngular.domain.model.Movie
import com.sngular.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlinx.coroutines.flow.map

class MoviesRepositoryImpl @Inject constructor(
    private val localDataSource: MoviesLocalDatasource,
    private val apiService: ApiService,
    private val mapper: MovieMapper
) : MoviesRepository {

    override val popularMovies: Flow<PagingData<Movie>> = Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
                initialLoadSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MoviesPagingSource(apiService, localDataSource, MovieCategory.Popular, mapper)
            }
        ).flow.map { pagingData ->
            pagingData.map { movieEntity ->
                mapper.entityToModel(movieEntity) // convert
            }
        }


    override val topRatedMovies: Flow<PagingData<Movie>> = Pager(
        config = PagingConfig(
            pageSize = 20,
            prefetchDistance = 10,
            initialLoadSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            MoviesPagingSource(apiService, localDataSource, MovieCategory.TopRated, mapper)
        }
    ).flow.map { pagingData ->
        pagingData.map { movieEntity ->
            mapper.entityToModel(movieEntity) // convert
        }
    }

    override val suggestedMovies: Flow<PagingData<Movie>> = Pager(
        config = PagingConfig(
            pageSize = 20,
            prefetchDistance = 10,
            initialLoadSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            MoviesPagingSource(apiService, localDataSource, MovieCategory.Suggested, mapper)
        }
    ).flow.map { pagingData ->
        pagingData.map { movieEntity ->
            mapper.entityToModel(movieEntity) // convert
        }
    }

}