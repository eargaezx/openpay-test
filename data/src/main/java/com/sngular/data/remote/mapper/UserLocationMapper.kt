package com.sngular.data.remote.mapper

import com.sngular.data.remote.dto.UserLocationDto
import com.sngular.domain.model.UserLocation

object UserLocationMapper : Mapper<Any, UserLocationDto, UserLocation> {

    override fun dtoToModel(input: UserLocationDto) = with(input) {
        UserLocation(
            latitude = latitude,
            longitude = longitude,
            createdAt = createdAt
        )
    }

    fun modelToDto(input: UserLocation) = with(input) {
        UserLocationDto(
            latitude = latitude,
            longitude = longitude,
            createdAt = createdAt
        )
    }

    override fun modelToEntity(type: UserLocation): Any {
        TODO("Not yet implemented")
    }

    override fun entityToModel(type: Any): UserLocation {
        TODO("Not yet implemented")
    }


}