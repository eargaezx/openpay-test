package com.sngular.domain.datasource.local

import com.sngular.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface PhotosLocalDatasource {
    fun getAll(): Flow<Result<List<Photo>>>

    fun setLocation(location: Photo): Flow<Result<Boolean>>

}