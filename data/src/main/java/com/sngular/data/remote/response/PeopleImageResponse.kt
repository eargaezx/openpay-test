package com.sngular.data.remote.response

import com.google.gson.annotations.SerializedName
import com.sngular.data.remote.dto.PeopleDto
import com.sngular.data.remote.dto.PeopleImageDto

data class PeopleImageResponse (
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("profiles")
    val profiles: List<PeopleImageDto> = listOf(),
)

