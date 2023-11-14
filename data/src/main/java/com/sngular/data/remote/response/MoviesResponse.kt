package com.sngular.data.remote.response

import com.google.gson.annotations.SerializedName
import com.sngular.data.remote.dto.MovieDto

data class MoviesResponse (
    @SerializedName("page")
    val page: Int = 0,

    @SerializedName("total_pages")
    val totalPages: Int = 0,

    @SerializedName("total_results")
    val totalResults: Int = 0,

    @SerializedName("results")
    val results: List<MovieDto> = listOf(),
)

