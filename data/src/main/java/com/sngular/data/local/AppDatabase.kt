package com.sngular.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sngular.data.local.dao.MovieDao
import com.sngular.data.local.dao.MovieKeyDao
import com.sngular.data.local.dao.PeopleDao
import com.sngular.data.local.dao.PeopleImageDao
import com.sngular.data.local.dao.ReviewDao
import com.sngular.data.local.entity.MovieEntity
import com.sngular.data.local.entity.MovieKeyEntity
import com.sngular.data.local.entity.PeopleEntity
import com.sngular.data.local.entity.PeopleImageEntity
import com.sngular.data.local.entity.ReviewEntity

@Database(
    entities = [
        MovieEntity::class,
        MovieKeyEntity::class,
        PeopleEntity::class,
        PeopleImageEntity::class,
        ReviewEntity::class
    ], version = 4
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun movieKeyDao(): MovieKeyDao

    abstract fun peopleDao(): PeopleDao

    abstract fun peopleImageDao(): PeopleImageDao

    abstract fun reviewDao(): ReviewDao
}
