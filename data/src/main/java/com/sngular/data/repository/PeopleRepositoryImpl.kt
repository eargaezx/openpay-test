package com.sngular.data.repository

import com.sngular.domain.datasource.local.PeopleLocalDatasource
import com.sngular.domain.datasource.remote.PeopleRemoteDatasource
import com.sngular.domain.model.People
import com.sngular.domain.repository.PeopleRepository
import com.sngular.domain.state.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(
    private val remoteDatasourceImpl: PeopleRemoteDatasource,
    private val localDatasource: PeopleLocalDatasource
) : PeopleRepository {
    override val profile: Flow<Result<People>> = flow {
        emit(Result.Loading())
        try {
            var people = remoteDatasourceImpl.getPopular().data
            if(people != null){
                localDatasource.clearAll()
                localDatasource.insert(people)
            }else{
                people = localDatasource.getPeople()
            }
            emit(Result.Success(people))
        } catch (e: Exception) {
            emit(Result.Error("Couldn't reach server. Check your internet connection!"))
        }
    }



}