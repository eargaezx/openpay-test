package com.sngular.domain.usecase

import android.net.Uri
import com.sngular.domain.repository.UserImagesRespository
import javax.inject.Inject
import com.sngular.domain.state.Result

class UploadImagesUseCase @Inject constructor(
    private val repository: UserImagesRespository
){
     suspend operator fun invoke(fileUri: List<Uri>, onResult: (Result<List<Uri>>) -> Unit){
        repository.uploadFiles(fileUri, onResult)
    }
}