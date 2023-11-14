package com.sngular.domain.datasource.local

import com.sngular.domain.model.UserLocation
import kotlinx.coroutines.flow.Flow

interface LocationsLocalDatasource {
    fun getAll(): Flow<Result<List<UserLocation>>>

    fun setLocation(userLocation: UserLocation): Flow<Result<Boolean>>

}