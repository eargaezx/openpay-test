package com.sngular.data.remote.dto

import com.google.gson.annotations.SerializedName

class ReviewDto(
    @SerializedName("author")
    val author: String = "",

    @SerializedName("content")
    val content: String = "",

)

