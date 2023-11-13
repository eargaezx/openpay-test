package com.sngular.domain.repository

import com.sngular.domain.model.UserLocation
import kotlinx.coroutines.flow.Flow
import com.sngular.domain.state.Result

interface UserLocationsRespository {
    fun getAll(): Flow<Result<List<UserLocation>>>

    fun setLocation(userLocation: UserLocation): Flow<Result<Boolean>>

}