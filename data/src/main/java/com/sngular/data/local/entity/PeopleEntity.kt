package com.sngular.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class PeopleEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "profile_path")
    val profilePath: String?,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "known_for_department")
    val profile: String,

    @ColumnInfo(name = "popularity")
    val popularity: Double



)

