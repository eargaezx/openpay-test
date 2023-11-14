package com.sngular.data.di

import com.sngular.data.local.AppDatabase
import com.sngular.data.local.dao.MovieDao
import com.sngular.data.local.dao.PeopleDao
import com.sngular.data.local.dao.PeopleImageDao
import com.sngular.data.local.dao.ReviewDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    /***************************************************************
     *START PROVIDE DAOS
     *************************************************************/
    @Provides
    @Singleton
    fun provideMovieDao(appDatabase: AppDatabase): MovieDao{
        return appDatabase.movieDao()
    }

    @Provides
    @Singleton
    fun providePeopleDao(appDatabase: AppDatabase): PeopleDao{
        return appDatabase.peopleDao()
    }

    @Provides
    @Singleton
    fun providePeopleImageDao(appDatabase: AppDatabase): PeopleImageDao{
        return appDatabase.peopleImageDao()
    }

    @Provides
    @Singleton
    fun provideReviewDao(appDatabase: AppDatabase): ReviewDao{
        return appDatabase.reviewDao()
    }

}