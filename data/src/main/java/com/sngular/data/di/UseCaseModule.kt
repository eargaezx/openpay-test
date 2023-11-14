package com.sngular.data.di

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
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
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
}