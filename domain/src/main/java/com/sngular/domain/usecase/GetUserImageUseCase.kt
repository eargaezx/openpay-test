package com.sngular.domain.usecase

import com.sngular.domain.model.UserImage
import com.sngular.domain.repository.UserImagesRespository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import com.sngular.domain.state.Result

class GetUserImageUseCase @Inject constructor(
    private val repository: UserImagesRespository
){
     operator fun invoke(): Flow<Result<List<UserImage>>> {
        return repository.getAll()
    }
}