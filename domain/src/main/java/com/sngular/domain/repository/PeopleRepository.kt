package com.sngular.domain.repository

import com.sngular.domain.model.People
import kotlinx.coroutines.flow.Flow
import com.sngular.domain.state.Result

interface PeopleRepository {
    val profile: Flow<Result<People>>

}