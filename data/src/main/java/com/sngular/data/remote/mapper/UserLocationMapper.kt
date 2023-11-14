package com.sngular.data.remote.mapper

import com.sngular.data.remote.dto.UserLocationDto
import com.sngular.domain.model.UserLocation

class UserLocationMapper {
    companion object{
        fun dtoToModel(input: UserLocationDto) = with(input){
            UserLocation(
                latitude = latitude,
                longitude = longitude,
                createdAt = createdAt
            )
        }

        fun modelToDto(input: UserLocation) = with(input){
            UserLocationDto(
                latitude = latitude,
                longitude = longitude,
                createdAt = createdAt
            )
        }

    }
}