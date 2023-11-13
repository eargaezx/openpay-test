package com.sngular.domain.model

import com.google.firebase.Timestamp
import com.google.gson.annotations.SerializedName

class Movie (
    @SerializedName("id")
    val id: Int,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("title")
    val title: String,

    @SerializedName("popularity")
    val popularity: Double,

    @SerializedName("vote_average")
    val voteAverage: Double,

    @SerializedName("vote_count")
    val voteCount: Int,

    @SerializedName("page")
    val page: Int

)

