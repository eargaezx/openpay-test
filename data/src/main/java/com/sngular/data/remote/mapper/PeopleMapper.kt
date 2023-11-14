package com.sngular.data.remote.mapper

import com.sngular.data.local.entity.MovieEntity
import com.sngular.data.local.entity.PeopleEntity
import com.sngular.data.remote.dto.MovieDto
import com.sngular.data.remote.dto.PeopleDto
import com.sngular.domain.model.Movie
import com.sngular.domain.model.People

class PeopleMapper {
    companion object{
        fun dtoToModel(input: PeopleDto) = with(input){
            People(
                id = id,
                profilePath = profilePath,
                name = name,
                popularity = popularity,
                profile = profile
            )
        }

        fun modelToEntity(input: People) = with(input){
            PeopleEntity(
                id = id,
                profilePath = profilePath,
                name = name,
                popularity = popularity,
                profile = profile
            )
        }

        fun entityToModel(input: PeopleEntity) = with(input){
            People(
                id = id,
                profilePath = profilePath,
                name = name,
                popularity = popularity,
                profile = profile
            )
        }

    }
}