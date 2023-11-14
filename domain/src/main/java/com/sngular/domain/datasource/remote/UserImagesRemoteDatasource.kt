package com.sngular.domain.datasource.remote

import android.net.Uri
import com.sngular.domain.model.UserImage
import com.sngular.domain.state.Result
import kotlinx.coroutines.flow.Flow

interface UserImagesRemoteDatasource {

    val images: Flow<Result<List<UserImage>>>

     suspend fun uploadFiles(
        fileUri: List<Uri>
    )

}