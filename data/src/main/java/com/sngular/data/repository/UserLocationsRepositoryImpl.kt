package com.sngular.data.repository

import com.sngular.domain.datasource.remote.UserLocationsRemoteDatasource
import com.sngular.domain.model.UserLocation
import javax.inject.Inject
import com.sngular.domain.repository.UserLocationsRespository
import kotlinx.coroutines.flow.Flow
import com.sngular.domain.state.Result


class UserLocationsRepositoryImpl @Inject constructor(
    private val dataSource: UserLocationsRemoteDatasource
): UserLocationsRespository {
    override fun getAll(): Flow<Result<List<UserLocation>>> {
        return dataSource.locations
    }

    override fun setLocation(userLocation: UserLocation): Flow<Result<Boolean>> {
        TODO("Not yet implemented")
    }
}