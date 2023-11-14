package com.sngular.data.remote.mapper

import com.sngular.data.remote.dto.UserImageDto
import com.sngular.data.remote.dto.UserLocationDto
import com.sngular.domain.model.UserImage
import com.sngular.domain.model.UserLocation

class UserImageMapper {
    companion object{
        fun dtoToModel(input: UserImageDto) = with(input){
            UserImage(
               imagePath = imagePath
            )
        }
    }
}