package com.sngular.data.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.sngular.data.BuildConfig
import com.sngular.data.datasource.local.MoviesLocalDatasourceImpl
import com.sngular.data.datasource.remote.MoviesRemoteDatasourceImpl
import com.sngular.data.network.api.ApiAdapter
import com.sngular.data.network.api.ApiService
import com.sngular.data.network.mapper.MovieMapper
import com.sngular.data.repository.MoviesRepositoryImpl
import com.sngular.domain.datasource.local.MoviesLocalDatasource
import com.sngular.domain.datasource.remote.MoviesRemoteDatasource
import com.sngular.domain.repository.MoviesRepository
import com.sngular.domain.usecase.GetMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /***************************************************************
    *START PROVIDE API SERVICES
    */
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

    /***************************************************************
     *START PROVIDE DATASOURCES
     */

    @Provides
    @Singleton
    fun provideMoviesRemoteDatasource(apiService: ApiService, mapper: MovieMapper): MoviesRemoteDatasource{
        return MoviesRemoteDatasourceImpl(apiService, mapper)
    }

    @Provides
    @Singleton
    fun provideMoviesLocalDatasource(apiService: ApiService, mapper: MovieMapper): MoviesLocalDatasource{
        return MoviesLocalDatasourceImpl(apiService, mapper)
    }

    /***************************************************************
     *START PROVIDE REPOSITORIES
     */
    @Provides
    @Singleton
    fun provideMoviesRepository(remoteDatasource: MoviesRemoteDatasource, localDatasource: MoviesLocalDatasource): MoviesRepository{
        return MoviesRepositoryImpl(localDatasource, remoteDatasource)
    }


    /***************************************************************
     *START PROVIDE MAPPERS
     */
    @Provides
    @Singleton
    fun provideMovieMapper(): MovieMapper{
        return MovieMapper()
    }


    /***************************************************************
     *START PROVIDE USECASES
     */
    @Provides
    @Singleton
    fun provideGetMoviesUseCase(repository: MoviesRepository): GetMoviesUseCase{
        return GetMoviesUseCase(repository)
    }

}