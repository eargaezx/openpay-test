package com.sngular.data.remote.mapper

import com.sngular.data.local.entity.PeopleImageEntity
import com.sngular.data.remote.dto.PeopleImageDto
import com.sngular.domain.model.PeopleImage

object PeopleImageMapper: Mapper<PeopleImageEntity, PeopleImageDto, PeopleImage> {

    override fun dtoToModel(input: PeopleImageDto) = with(input) {
        PeopleImage(
            filePath = filePath
        )
    }

    override fun modelToEntity(input: PeopleImage) = with(input) {
        PeopleImageEntity(
            filePath = filePath
        )
    }

    override fun entityToModel(input: PeopleImageEntity) = with(input) {
        PeopleImage(
            filePath = filePath
        )
    }



}