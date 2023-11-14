package com.sngular.domain.repository

import android.net.Uri
import com.google.firebase.storage.StorageReference
import com.sngular.domain.model.UserImage
import com.sngular.domain.state.Result
import kotlinx.coroutines.flow.Flow

interface UserImagesRespository {
    val images: Flow<Result<List<UserImage>>>
     suspend fun uploadFiles(
        fileUri: List<Uri>,
        onResult: (Result<List<Uri>>) -> Unit
    )

}