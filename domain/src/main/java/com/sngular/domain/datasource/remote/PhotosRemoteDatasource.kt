package com.sngular.domain.datasource.remote

import com.sngular.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface PhotosRemoteDatasource {
    fun getAll(): Flow<Result<List<Photo>>>

    fun setLocation(location: Photo): Flow<Result<Boolean>>

}