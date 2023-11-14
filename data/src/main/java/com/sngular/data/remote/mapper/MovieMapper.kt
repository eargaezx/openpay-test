package com.sngular.data.remote.mapper

import com.sngular.data.local.entity.MovieEntity
import com.sngular.data.remote.dto.MovieDto
import com.sngular.domain.model.Movie

class MovieMapper {
     fun toModel(input: MovieEntity) = with(input){
        Movie(
            id = id,
            posterPath = posterPath,
            title = title,
            popularity = popularity,
            voteAverage = voteAverage,
            voteCount = voteCount,
            page = page
        )
    }

    fun toModel(input: MovieDto) = with(input){
        Movie(
            id = id,
            posterPath = posterPath,
            title = title,
            popularity = popularity,
            voteAverage = voteAverage,
            voteCount = voteCount,
            page = page
        )
    }

    fun fromModel(input: Movie) = with(input){
        MovieEntity(
            id = id,
            posterPath = posterPath,
            title = title,
            popularity = popularity,
            voteAverage = voteAverage,
            voteCount = voteCount,
            page = page
        )
    }

     fun fromDto(input: MovieDto) = with(input){
        MovieEntity(
            id = id,
            posterPath = posterPath,
            title = title,
            popularity = popularity,
            voteAverage = voteAverage,
            voteCount = voteCount,
            page = page
        )
    }


}