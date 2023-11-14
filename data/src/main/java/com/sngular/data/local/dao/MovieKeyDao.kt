package com.sngular.data.local.dao

import androidx.room.*
import com.sngular.data.local.entity.MovieEntity
import com.sngular.data.local.entity.MovieKeyEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
interface MovieKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(remoteKey: List<MovieKeyEntity>)

    @Query("Select * From MovieKeyEntity Where movie_id = :id")
    fun getRemoteKeyByMovieID(id: Int): MovieKeyEntity?

    @Query("Delete From MovieKeyEntity")
    fun clearRemoteKeys()

    @Query("Select created_at From MovieKeyEntity Order By created_at DESC LIMIT 1")
    fun getCreationTime(): Long?

    @Query("Delete From MovieKeyEntity")
    fun clearAll()
}
