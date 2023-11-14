package com.sngular.data.local.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.sngular.data.local.entity.MovieEntity
import com.sngular.data.local.entity.PeopleEntity
import com.sngular.data.local.entity.PeopleImageEntity
import com.sngular.domain.model.People
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
interface PeopleDao {

    @Query("SELECT * FROM PeopleEntity")
    fun getFirst(): List<PeopleEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: PeopleEntity)

    @Query("Delete From PeopleEntity")
    fun clearAll()
}
