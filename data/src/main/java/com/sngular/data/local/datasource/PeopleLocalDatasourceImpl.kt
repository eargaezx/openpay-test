package com.sngular.data.local.datasource

import com.sngular.data.local.dao.PeopleDao
import com.sngular.data.local.dao.PeopleImageDao
import com.sngular.data.remote.mapper.PeopleImageMapper
import com.sngular.data.remote.mapper.PeopleMapper
import javax.inject.Inject
import com.sngular.domain.datasource.local.PeopleLocalDatasource
import com.sngular.domain.model.People

class PeopleLocalDatasourceImpl @Inject constructor(
    private val peopleDao: PeopleDao,
    private val peopleImageDao: PeopleImageDao
) : PeopleLocalDatasource{
    override suspend fun getPeople(): People {
        val people = peopleDao.getFirst().map { PeopleMapper.entityToModel(it) }.first()
        people.peopleImages = peopleImageDao.getAll().map { PeopleImageMapper.entityToModel(it) }
        return  people
    }

    override suspend fun insert(people: People) {
        peopleImageDao.insertAll(
            people.peopleImages.map { PeopleImageMapper.modelToEntity(it) }
        )
        return peopleDao.insert(PeopleMapper.modelToEntity(people))
    }

    override suspend fun clearAll() {
        peopleImageDao.clearAll()
        return peopleDao.clearAll()
    }
}