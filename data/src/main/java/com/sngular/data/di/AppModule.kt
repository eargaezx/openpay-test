package com.sngular.data.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.sngular.data.BuildConfig
import com.sngular.data.local.AppDatabase
import com.sngular.data.local.dao.MovieDao
import com.sngular.data.local.dao.PeopleDao
import com.sngular.data.local.dao.PeopleImageDao
import com.sngular.data.local.datasource.MoviesLocalDatasourceImpl
import com.sngular.data.local.datasource.PeopleLocalDatasourceImpl
import com.sngular.data.remote.datasource.MoviesRemoteDatasourceImpl
import com.sngular.data.remote.api.ApiAdapter
import com.sngular.data.remote.api.ApiService
import com.sngular.data.remote.datasource.PeopleRemoteDatasourceImpl
import com.sngular.data.remote.datasource.UserLocationsRemoteDataSourceImpl
import com.sngular.data.remote.mapper.MovieMapper
import com.sngular.data.repository.MoviesRepositoryImpl
import com.sngular.data.repository.PeopleRepositoryImpl
import com.sngular.data.repository.UserImagesRepositoryImpl
import com.sngular.data.repository.UserLocationsRepositoryImpl
import com.sngular.domain.datasource.local.MoviesLocalDatasource
import com.sngular.domain.datasource.local.PeopleLocalDatasource
import com.sngular.domain.datasource.remote.MoviesRemoteDatasource
import com.sngular.domain.datasource.remote.PeopleRemoteDatasource
import com.sngular.domain.datasource.remote.UserLocationsRemoteDatasource
import com.sngular.domain.repository.MoviesRepository
import com.sngular.domain.repository.PeopleRepository
import com.sngular.domain.repository.UserImagesRespository
import com.sngular.domain.repository.UserLocationsRespository
import com.sngular.domain.usecase.GetMoviesUseCase
import com.sngular.domain.usecase.GetPeopleUseCase
import com.sngular.domain.usecase.GetUserImageUseCase
import com.sngular.domain.usecase.GetUserLocationUseCase
import com.sngular.domain.usecase.UploadImagesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    /***************************************************************
     *START PROVIDE LOCAL DATABASE
     *************************************************************/
    @Provides
    @Singleton
    fun providesRoomDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, AppDatabase::class.java, "database")
        .fallbackToDestructiveMigration()
        .build()


    /***************************************************************
    *START PROVIDE API SERVICES
     *************************************************************/
    @Provides
    @Singleton
    fun provideApiService(okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient) // <-- usamos el log level
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient() = ApiAdapter.okHttpClient()

    @Provides
    @Singleton
    fun provideDatabase(): FirebaseFirestore{
        return Firebase.firestore
    }


    @Singleton
    @Provides
    fun provideFirebaseStroageInstance(): StorageReference {
        return FirebaseStorage.getInstance().getReference("user")
    }


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
    fun provideUserImagesRepository(firestore: FirebaseFirestore, storageReference: StorageReference): UserImagesRespository{
        return UserImagesRepositoryImpl(firestore, storageReference)
    }


    /***************************************************************
     *START PROVIDE MAPPERS
     *************************************************************/
    @Provides
    @Singleton
    fun provideMovieMapper(): MovieMapper {
        return MovieMapper()
    }


    /***************************************************************
     *START PROVIDE USECASES
     *************************************************************/
    @Provides
    @Singleton
    fun provideGetMoviesUseCase(repository: MoviesRepository): GetMoviesUseCase{
        return GetMoviesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetPeopleUseCase(repository: PeopleRepository): GetPeopleUseCase{
        return GetPeopleUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetUserlocationUseCase(repository: UserLocationsRespository): GetUserLocationUseCase{
        return GetUserLocationUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideUploadImagesUseCase(repository: UserImagesRespository): UploadImagesUseCase{
        return UploadImagesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetUserImageUseCase(repository: UserImagesRespository): GetUserImageUseCase{
        return GetUserImageUseCase(repository)
    }

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
    fun providePeopleLocalDatasource(peopleDao: PeopleDao, peopleImageDao: PeopleImageDao): PeopleLocalDatasource{
        return PeopleLocalDatasourceImpl(peopleDao, peopleImageDao)
    }


    @Provides
    @Singleton
    fun provideUserLocationsDatasource(firestore: FirebaseFirestore): UserLocationsRemoteDatasource{
        return UserLocationsRemoteDataSourceImpl(firestore)
    }


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

}