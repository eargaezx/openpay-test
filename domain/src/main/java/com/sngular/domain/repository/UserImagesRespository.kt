package com.sngular.domain.repository

import android.net.Uri
import com.sngular.domain.model.UserImage
import com.sngular.domain.state.Result
import kotlinx.coroutines.flow.Flow

interface UserImagesRespository {
    fun getAll(): Flow<Result<List<UserImage>>>
     suspend fun uploadFiles(
        fileUri: List<Uri>
    )

}