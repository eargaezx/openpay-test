package com.sngular.openpaytest.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sngular.domain.model.People
import com.sngular.domain.usecase.GetPeopleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import com.sngular.domain.state.Result

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCase: GetPeopleUseCase,
) : ViewModel() {
    val uiState = useCase.invoke()

}