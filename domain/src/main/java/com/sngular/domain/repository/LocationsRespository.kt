package com.sngular.domain.repository

import com.sngular.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface LocationsRespository {
    fun getAll(): Flow<Result<List<Location>>>

    fun setLocation(location: Location): Flow<Result<Boolean>>

}