package com.sngular.data.remote.dto

import com.google.firebase.Timestamp
import com.google.gson.annotations.SerializedName

class UserLocationDto (
    @SerializedName("latitude")
    val latitude: Double = 0.0,

    @SerializedName("longitude")
    val longitude: Double = 0.0,

    @SerializedName("createdAt")
    val createdAt: Timestamp = Timestamp.now()
)

