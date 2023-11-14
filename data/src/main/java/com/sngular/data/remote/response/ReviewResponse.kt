package com.sngular.data.remote.response

import com.google.gson.annotations.SerializedName
import com.sngular.data.remote.dto.ReviewDto

data class ReviewResponse (
    @SerializedName("page")
    val page: Int = 0,

    @SerializedName("results")
    val results: List<ReviewDto> = listOf(),
)

