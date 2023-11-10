package com.sngular.data.datasource.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.sngular.domain.datasource.remote.MoviesRemoteDatasource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.sngular.domain.common.Result
import com.sngular.domain.model.Movie

class MoviesRemoteDatasourceImpl @Inject constructor(
    private val firebaseFirestore: FirebaseFirestore
) : MoviesRemoteDatasource {
    override fun getAll(): Flow<Result<List<Movie>>> {
       return flow {
            emit(Result.Success(listOf<Movie>()))
        }
    }
}