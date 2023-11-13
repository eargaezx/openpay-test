package com.sngular.data.remote.mapper

import com.sngular.data.local.entity.MovieEntity
import com.sngular.data.local.entity.PeopleImageEntity
import com.sngular.data.remote.dto.MovieDto
import com.sngular.data.remote.dto.PeopleDto
import com.sngular.data.remote.dto.PeopleImageDto
import com.sngular.domain.model.Movie
import com.sngular.domain.model.People
import com.sngular.domain.model.PeopleImage

class PeopleImageMapper {
    companion object{
        fun dtoToModel(input: PeopleImageDto) = with(input){
            PeopleImage(
                filePath = filePath
            )
        }

        fun modelToEntity(input: PeopleImage) = with(input){
            PeopleImageEntity(
                filePath = filePath
            )
        }

        fun entityToModel(input: PeopleImageEntity) = with(input){
            PeopleImage(
                filePath = filePath
            )
        }

    }
}