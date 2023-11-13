package com.sngular.domain.datasource.remote

import com.sngular.domain.model.People
import com.sngular.domain.model.PeopleImage
import com.sngular.domain.state.Result

interface PeopleRemoteDatasource {
    suspend fun getPopular(): Result<People>

    suspend fun getImages(peopleId: Int): Result<List<PeopleImage>>
}