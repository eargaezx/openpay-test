package com.sngular.domain.model

import com.google.gson.annotations.SerializedName

class Review(
    @SerializedName("author")
    val author: String? = "",

    @SerializedName("content")
    val content: String? = "",

)

