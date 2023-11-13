package com.sngular.domain.usecase

import com.sngular.domain.model.People
import com.sngular.domain.repository.PeopleRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import com.sngular.domain.state.Result
import javax.inject.Inject

class GetPeopleUseCase @Inject constructor(
    private val repository: PeopleRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
){
    operator fun invoke():  Flow<Result<People>> {
        return repository.profile.flowOn(dispatcher)
    }
}