package com.sngular.domain.datasource.local

import com.sngular.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface LocationsLocalDatasource {
    fun getAll(): Flow<Result<List<Location>>>

    fun setLocation(location: Location): Flow<Result<Boolean>>

}