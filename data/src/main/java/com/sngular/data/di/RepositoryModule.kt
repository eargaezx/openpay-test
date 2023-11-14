package com.sngular.data.di

import com.sngular.data.local.AppDatabase
import com.sngular.data.remote.api.ApiService
import com.sngular.data.remote.mapper.MovieMapper
import com.sngular.data.repository.MoviesRepositoryImpl
import com.sngular.data.repository.PeopleRepositoryImpl
import com.sngular.data.repository.UserImagesRepositoryImpl
import com.sngular.data.repository.UserLocationsRepositoryImpl
import com.sngular.domain.datasource.local.MoviesLocalDatasource
import com.sngular.domain.datasource.local.PeopleLocalDatasource
import com.sngular.domain.datasource.remote.MoviesRemoteDatasource
import com.sngular.domain.datasource.remote.PeopleRemoteDatasource
import com.sngular.domain.datasource.remote.UserImagesRemoteDatasource
import com.sngular.domain.datasource.remote.UserLocationsRemoteDatasource
import com.sngular.domain.repository.MoviesRepository
import com.sngular.domain.repository.PeopleRepository
import com.sngular.domain.repository.UserImagesRespository
import com.sngular.domain.repository.UserLocationsRespository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    /***************************************************************
     *START PROVIDE REPOSITORIES
     *************************************************************/
    @Provides
    @Singleton
    fun provideMoviesRepository(remoteDatasource: MoviesRemoteDatasource,
                                localDatasource: MoviesLocalDatasource,
                                database: AppDatabase,
                                apiService: ApiService,
                                mapper: MovieMapper): MoviesRepository{
        return MoviesRepositoryImpl(localDatasource, apiService, mapper)
    }

    @Provides
    @Singleton
    fun providePeopleRepository(peopleRemoteDatasource: PeopleRemoteDatasource,
                                peopleLocalDatasource: PeopleLocalDatasource): PeopleRepository{
        return PeopleRepositoryImpl(peopleRemoteDatasource, peopleLocalDatasource)
    }

    @Provides
    @Singleton
    fun provideUserLocationsRepository(remoteDatasource: UserLocationsRemoteDatasource): UserLocationsRespository{
        return UserLocationsRepositoryImpl(remoteDatasource)
    }

    @Provides
    @Singleton
    fun provideUserImagesRepository(remoteDatasource: UserImagesRemoteDatasource): UserImagesRespository{
        return UserImagesRepositoryImpl(remoteDatasource)
    }


}