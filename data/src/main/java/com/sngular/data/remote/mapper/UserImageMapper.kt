package com.sngular.data.remote.mapper

import com.sngular.data.remote.dto.UserImageDto
import com.sngular.domain.model.UserImage

object UserImageMapper: Mapper<Any, UserImageDto, UserImage> {

        override fun dtoToModel(input: UserImageDto) = with(input){
            UserImage(
               imagePath = imagePath
            )
        }

    override fun modelToEntity(type: UserImage): Any {
        TODO("Not yet implemented")
    }

    override fun entityToModel(type: Any): UserImage {
        TODO("Not yet implemented")
    }

}