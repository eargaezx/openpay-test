package com.sngular.data.local.dao

import androidx.room.*
import com.sngular.data.local.entity.PeopleImageEntity

@Dao
interface PeopleImageDao {

    @Query("SELECT * FROM PeopleImageEntity")
    fun getAll(): List<PeopleImageEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: PeopleImageEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(images: List<PeopleImageEntity>)

    @Query("Delete From PeopleImageEntity")
    fun clearAll()
}
