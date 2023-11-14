package com.sngular.data.local.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.sngular.data.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
interface MovieDao {

    @Query("SELECT * FROM MovieEntity WHERE id IN (SELECT id FROM MovieEntity ORDER BY RANDOM() LIMIT :size)")
    fun getAll(size: Int): List<MovieEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: List<MovieEntity>)

    @Delete
    fun deleteAll(movie: List<MovieEntity>)

    @Query("Delete From MovieEntity")
    fun clearAll()
}
