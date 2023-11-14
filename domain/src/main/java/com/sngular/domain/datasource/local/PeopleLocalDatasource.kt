package com.sngular.domain.datasource.local

import com.sngular.domain.model.Movie
import com.sngular.domain.model.People

interface PeopleLocalDatasource {
    suspend fun getPeople(): People
    suspend fun insert(people: People)

    suspend fun clearAll()

}