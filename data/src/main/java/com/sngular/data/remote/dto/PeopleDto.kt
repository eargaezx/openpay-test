package com.sngular.data.remote.dto

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.firebase.Timestamp
import com.google.gson.annotations.SerializedName

class PeopleDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("profile_path")
    val profilePath: String?,

    @SerializedName("name")
    val name: String,

    @SerializedName("known_for_department")
    val profile: String,

    @SerializedName("popularity")
    val popularity: Double,

)

