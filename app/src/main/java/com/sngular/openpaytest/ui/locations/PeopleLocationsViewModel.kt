package com.sngular.openpaytest.ui.locations

import androidx.lifecycle.ViewModel
import com.sngular.domain.usecase.GetUserLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PeopleLocationsViewModel  @Inject constructor(
    private val useCase: GetUserLocationUseCase,
): ViewModel() {
    val locations = useCase.invoke()

}