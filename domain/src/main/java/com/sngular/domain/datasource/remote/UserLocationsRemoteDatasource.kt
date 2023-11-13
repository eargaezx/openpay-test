package com.sngular.domain.datasource.remote

import com.sngular.domain.model.UserLocation
import kotlinx.coroutines.flow.Flow
import com.sngular.domain.state.Result

interface UserLocationsRemoteDatasource {

    val locations:  Flow<Result<List<UserLocation>>>

    fun setLocation(userLocation: UserLocation): Flow<Result<Boolean>>

}