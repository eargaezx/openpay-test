package com.sngular.data.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.sngular.data.BuildConfig
import com.sngular.data.network.api.ApiAdapter
import com.sngular.data.network.api.ApiService
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

    /*@Provides
    @Singleton
    fun provideRemindsDataSource(source: FirebaseFirestore, mapper: ReminderMapper): RemindersDataSource{
        return RemindersDataSourceImpl(source, mapper)
    }

    @Provides
    @Singleton
    fun provideMoviesRepository(remoteDatasource: MoviesRemoteDatasource, mapper: ReminderMapper): MoviesRepository{
        return RemindersRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideReminderMapper(): ReminderMapper{
        return ReminderMapper()
    }


    @Provides
    @Singleton
    fun provideGetRemindersUseCase(repository: RemindersRepository): GetRemindersUseCase{
        return GetRemindersUseCase(repository)
    }*/

}