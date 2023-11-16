package com.sngular.data.remote.mapper

import com.sngular.data.local.entity.PeopleEntity
import com.sngular.data.remote.dto.PeopleDto
import com.sngular.domain.model.People

object PeopleMapper : Mapper<PeopleEntity, PeopleDto, People> {
    override fun dtoToModel(input: PeopleDto) = with(input) {
        People(
            id = id,
            profilePath = profilePath,
            name = name,
            popularity = popularity,
            profile = profile
        )
    }

    override fun modelToEntity(input: People) = with(input) {
        PeopleEntity(
            id = id,
            profilePath = profilePath,
            name = name,
            popularity = popularity,
            profile = profile
        )
    }

    override fun entityToModel(input: PeopleEntity) = with(input) {
        People(
            id = id,
            profilePath = profilePath,
            name = name,
            popularity = popularity,
            profile = profile
        )
    }

}