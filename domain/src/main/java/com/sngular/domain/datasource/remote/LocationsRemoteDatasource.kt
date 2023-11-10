package com.sngular.domain.datasource.remote

import com.sngular.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface LocationsRemoteDatasource {
    fun getAll(): Flow<Result<List<Location>>>

    fun setLocation(location: Location): Flow<Result<Boolean>>

}