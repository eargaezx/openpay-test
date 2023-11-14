package com.sngular.data.remote.datasource

import android.net.Uri
import com.google.firebase.FirebaseException
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.storage.StorageReference
import com.sngular.domain.repository.UserImagesRespository
import javax.inject.Inject
import com.sngular.domain.state.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import com.sngular.data.remote.dto.UserImageDto
import com.sngular.data.remote.mapper.UserImageMapper
import com.sngular.domain.datasource.remote.UserImagesRemoteDatasource
import com.sngular.domain.model.UserImage
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow


class UserImagesRemoteDatasourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val firebaseStorage: StorageReference
): UserImagesRemoteDatasource {

    override val images: Flow<Result<List<UserImage>>> = callbackFlow{
        trySend(Result.Loading())
        try {
            firestore.collection("images")
                .orderBy("createdAt", Query.Direction.DESCENDING)
                .addSnapshotListener { value, error ->
                    if(value != null){
                        val values = value.toObjects(UserImageDto::class.java)
                        trySend(
                            Result.Success(values.map {  UserImageMapper.dtoToModel(it) })
                        )
                    }

                }
        } catch (e: Exception){
            trySend(Result.Error(e.message ?: e.toString()))
        }
        awaitCancellation()
    }

    override suspend fun uploadFiles(
        fileUri: List<Uri>
    ) {
        try {
            val uri: List<Uri> = withContext(Dispatchers.IO) {
                fileUri.map { image ->
                    async {
                        firebaseStorage.child("images").child(image.lastPathSegment ?: "${System.currentTimeMillis()}")
                            .putFile(image)
                            .await()
                            .storage
                            .downloadUrl.addOnSuccessListener {
                                firestore.collection("images")
                                    .add(UserImageDto(it.toString()))
                            }
                            .await()
                    }
                }.awaitAll()
            }
           // onResult.invoke(Result.Success(uri))
        } catch (e: FirebaseException){
            //onResult.invoke(Result.Error(e.toString()))
        }catch (e: Exception){
            //onResult.invoke(Result.Error(e.toString()))
        }
    }

}