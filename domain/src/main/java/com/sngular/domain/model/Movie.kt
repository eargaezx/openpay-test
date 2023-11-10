package com.sngular.domain.model

import com.google.firebase.Timestamp
import com.google.gson.annotations.SerializedName

class Movie (
    @SerializedName("title")
    val title: String? = "",

    @SerializedName("poster_path")
    val posterPath: String? = "",

    @SerializedName("vote_average")
    val voteAverage: Float? = null,

    @SerializedName("vote_count")
    val voteCount: Int ? = null
)

