package com.sngular.openpaytest.ui.gallery

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sngular.domain.state.Result
import com.sngular.domain.usecase.GetUserImageUseCase
import com.sngular.domain.usecase.UploadImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val uploadImageUseCase: UploadImagesUseCase,
    private val getUserImageUseCase: GetUserImageUseCase
) : ViewModel() {
    val uploadedImages = getUserImageUseCase.invoke()

    fun uploadMultipleFile(fileUris: List<Uri>){
        viewModelScope.launch {
            uploadImageUseCase.invoke(fileUris)
        }
    }

}