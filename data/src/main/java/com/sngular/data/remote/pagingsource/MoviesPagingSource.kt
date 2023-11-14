package com.sngular.data.remote.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sngular.domain.model.MovieCategory
import com.sngular.data.local.entity.MovieEntity
import com.sngular.data.remote.api.ApiService
import com.sngular.data.remote.mapper.MovieMapper
import com.sngular.domain.datasource.local.MoviesLocalDatasource
import kotlinx.coroutines.delay
import retrofit2.HttpException
import java.io.IOException

class MoviesPagingSource (
    private val apiService: ApiService,
    private val datasource: MoviesLocalDatasource,
    private val movieCategory: MovieCategory
): PagingSource<Int, MovieEntity>(){
    private val INITIAL_PAGE_INDEX = 1
    private val INITIAL_PAGE_INDEX_REMOTE = 1
    private val mapper = MovieMapper()

    override fun getRefreshKey(state: PagingState<Int, MovieEntity>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)
        }
    }


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieEntity> {
        val pageNumber = params.key ?: INITIAL_PAGE_INDEX_REMOTE
        return try {
            val response = when(movieCategory){
                MovieCategory.Popular -> apiService.getPopularMovies(pageNumber)
                MovieCategory.TopRated -> apiService.getTopMovies(pageNumber)
                MovieCategory.Suggested -> apiService.getSuggestedMovies(pageNumber)
            }
            delay(2000L)
            val pagedResponse = response.body()
            val data = pagedResponse?.results?.map { mapper.fromDto(it) }.also { itr ->
                if (itr != null) {
                    datasource.insertAll( itr.map { mapper.toModel(it) })
                }
            }
            LoadResult.Page(
                data = data.orEmpty(),
                prevKey = null,
                nextKey = pageNumber + 1
            )
        } catch (e: IOException) {
            getLocalData(params , e)
        } catch (e: HttpException) {
            getLocalData(params, e)
        } catch (e: Exception) {
            getLocalData(params, e)
        }
    }


    private suspend fun getLocalData(params: LoadParams<Int>, e: Exception): LoadResult<Int, MovieEntity>{
        val pageNumberLocal = params.key ?: INITIAL_PAGE_INDEX
        val movies = datasource.getAll(params.loadSize)
        val result = movies.map { mapper.fromModel(it) }
        return if (result.isNotEmpty()) {
            LoadResult.Page(
                data = result,
                prevKey = if (pageNumberLocal == INITIAL_PAGE_INDEX) null else pageNumberLocal - 1,
                nextKey = if (result.isNullOrEmpty()) null else pageNumberLocal + 1
            )
        }else{
            LoadResult.Error(e)
        }
    }


}