package com.sngular.data.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference
import com.sngular.data.local.dao.MovieDao
import com.sngular.data.local.dao.PeopleDao
import com.sngular.data.local.dao.PeopleImageDao
import com.sngular.data.local.dao.ReviewDao
import com.sngular.data.local.datasource.MoviesLocalDatasourceImpl
import com.sngular.data.local.datasource.PeopleLocalDatasourceImpl
import com.sngular.data.remote.datasource.MoviesRemoteDatasourceImpl
import com.sngular.data.remote.api.ApiService
import com.sngular.data.remote.datasource.PeopleRemoteDatasourceImpl
import com.sngular.data.remote.datasource.UserImagesRemoteDatasourceImpl
import com.sngular.data.remote.datasource.UserLocationsRemoteDataSourceImpl
import com.sngular.data.remote.mapper.MovieMapper
import com.sngular.domain.datasource.local.MoviesLocalDatasource
import com.sngular.domain.datasource.local.PeopleLocalDatasource
import com.sngular.domain.datasource.remote.MoviesRemoteDatasource
import com.sngular.domain.datasource.remote.PeopleRemoteDatasource
import com.sngular.domain.datasource.remote.UserImagesRemoteDatasource
import com.sngular.domain.datasource.remote.UserLocationsRemoteDatasource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatasourceModule {
    /***************************************************************
     *START PROVIDE DATASOURCES
     *************************************************************/
    @Provides
    @Singleton
    fun provideMoviesRemoteDatasource(apiService: ApiService, mapper: MovieMapper): MoviesRemoteDatasource{
        return MoviesRemoteDatasourceImpl(apiService, mapper)
    }

    @Provides
    @Singleton
    fun provideMoviesLocalDatasource(movieDao: MovieDao, mapper: MovieMapper): MoviesLocalDatasource{
        return MoviesLocalDatasourceImpl(movieDao, mapper)
    }



    @Provides
    @Singleton
    fun providePeopleRemoteDatasource(apiService: ApiService): PeopleRemoteDatasource{
        return PeopleRemoteDatasourceImpl(apiService)
    }
    @Provides
    @Singleton
    fun providePeopleLocalDatasource(peopleDao: PeopleDao, peopleImageDao: PeopleImageDao, peopleReviewDao: ReviewDao): PeopleLocalDatasource{
        return PeopleLocalDatasourceImpl(peopleDao, peopleImageDao, peopleReviewDao)
    }


    @Provides
    @Singleton
    fun provideUserLocationsRemoteDatasource(firestore: FirebaseFirestore): UserLocationsRemoteDatasource{
        return UserLocationsRemoteDataSourceImpl(firestore)
    }

    @Provides
    @Singleton
    fun provideUserImagesRemoteDatasource(firestore: FirebaseFirestore, firebaseStorage: StorageReference): UserImagesRemoteDatasource{
        return UserImagesRemoteDatasourceImpl(firestore, firebaseStorage)
    }

}