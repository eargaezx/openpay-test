package com.sngular.data.network.response

import com.google.firebase.Timestamp
import com.google.gson.annotations.SerializedName
import com.sngular.data.network.dto.MovieDto

data class MoviesResponse (
    @SerializedName("page")
    val title: Int? = 0,

    @SerializedName("results")
    val results: List<MovieDto>? = listOf(),
)

