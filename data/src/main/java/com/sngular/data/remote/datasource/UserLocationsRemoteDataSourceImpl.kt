package com.sngular.data.remote.datasource

import com.google.firebase.firestore.FirebaseFirestore
import com.sngular.data.remote.dto.UserLocationDto
import com.sngular.data.remote.mapper.UserLocationMapper
import kotlinx.coroutines.flow.Flow
import com.sngular.domain.datasource.remote.UserLocationsRemoteDatasource
import com.sngular.domain.model.UserLocation
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.flow.callbackFlow
import com.sngular.domain.state.Result
import javax.inject.Inject

class UserLocationsRemoteDataSourceImpl @Inject constructor(
    private val source: FirebaseFirestore
): UserLocationsRemoteDatasource {

    override val locations:  Flow<Result<List<UserLocation>>> = callbackFlow{
        trySend(Result.Loading())
        // Register listener
        try {
            source.collection("locations")
                .addSnapshotListener { value, error ->
                    if(value != null){
                        val test = value.toObjects(UserLocationDto::class.java)
                        trySend(
                            Result.Success(test.map {  UserLocationMapper.dtoToModel(it) })
                        )
                    }

                }
        } catch (e: Exception) {
            trySend(Result.Error(e.message ?: e.toString()))
        }
        awaitCancellation()
    }


    override fun setLocation(userLocation: UserLocation): Flow<Result<Boolean>> = callbackFlow{
        trySend(Result.Loading())
        // Register listener
        try {
            source.collection("locations")
                .add(UserLocationMapper.modelToDto(userLocation))
                .addOnSuccessListener { documentReference ->
                   Result.Success(true)
                }
                .addOnFailureListener { e ->
                    trySend(Result.Error(e.message ?: e.toString()))
                }
        } catch (e: Exception) {
            trySend(Result.Error(e.message ?: e.toString()))
        }
        close()
    }
}