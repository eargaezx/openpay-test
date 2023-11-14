package com.sngular.data.remote.dto

import com.google.firebase.Timestamp
import com.google.gson.annotations.SerializedName
 class UserImageDto (
    @SerializedName("imagePath")
    val imagePath: String? = "",


    @SerializedName("createdAt")
    val createdAt: Timestamp = Timestamp.now()
)

