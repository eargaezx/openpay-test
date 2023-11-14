package com.sngular.domain.model

import android.net.Uri
import com.google.firebase.Timestamp
import com.google.firebase.storage.StorageReference
import com.google.gson.annotations.SerializedName

class UserImage(
    @SerializedName("imagePath")
    val imagePath: String?,


    @SerializedName("createdAt")
    val createdAt: Timestamp = Timestamp.now()
)

