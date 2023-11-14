package com.sngular.domain.usecase

import com.sngular.domain.model.UserLocation
import com.sngular.domain.repository.UserLocationsRespository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import com.sngular.domain.state.Result

class GetUserLocationUseCase @Inject constructor(
    private val repository: UserLocationsRespository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
){
     operator fun invoke(): Flow<Result<List<UserLocation>>> {
        return repository.getAll().flowOn(dispatcher)
    }
}