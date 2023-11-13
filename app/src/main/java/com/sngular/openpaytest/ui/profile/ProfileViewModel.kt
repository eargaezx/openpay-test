package com.sngular.openpaytest.ui.profile

import androidx.lifecycle.ViewModel
import com.sngular.domain.usecase.GetPeopleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCase: GetPeopleUseCase,
) : ViewModel() {
    val uiState = useCase.invoke()

}