package com.sngular.data.repository

import android.net.Uri
import com.sngular.domain.repository.UserImagesRespository
import javax.inject.Inject
import com.sngular.domain.state.Result
import com.sngular.domain.datasource.remote.UserImagesRemoteDatasource
import com.sngular.domain.model.UserImage
import kotlinx.coroutines.flow.Flow


class UserImagesRepositoryImpl @Inject constructor(
    private val remoteDatasource: UserImagesRemoteDatasource,
): UserImagesRespository {
    override fun getAll(): Flow<Result<List<UserImage>>> {
        return remoteDatasource.images
    }

    override suspend fun uploadFiles(
        fileUri: List<Uri>
    ) {
        remoteDatasource.uploadFiles(fileUri)
    }

}