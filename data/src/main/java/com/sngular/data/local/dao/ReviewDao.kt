package com.sngular.data.local.dao

import androidx.room.*
import com.sngular.data.local.entity.PeopleImageEntity
import com.sngular.data.local.entity.ReviewEntity

@Dao
interface ReviewDao {
    @Query("SELECT * FROM ReviewEntity")
    fun getAll(): List<ReviewEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: ReviewEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(images: List<ReviewEntity>)

    @Query("Delete From ReviewEntity")
    fun clearAll()
}
