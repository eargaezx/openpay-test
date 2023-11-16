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
import com.sngular.data.remote.api.ApiAdapter
import com.sngular.data.remote.api.ApiService
import com.sngular.data.remote.mapper.MovieMapper
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
     *START PROVIDE DATABASES
     *************************************************************/
    @Provides
    @Singleton
    fun providesRoomDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, AppDatabase::class.java, "database")
        .fallbackToDestructiveMigration()
        .build()

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


    /***************************************************************
     *START PROVIDE MAPPERS
     *************************************************************/
    @Provides
    @Singleton
    fun provideMovieMapper(): MovieMapper {
        return MovieMapper
    }
}