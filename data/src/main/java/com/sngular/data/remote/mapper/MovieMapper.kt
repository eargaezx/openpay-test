package com.sngular.data.remote.mapper

import com.sngular.data.local.entity.MovieEntity
import com.sngular.data.remote.dto.MovieDto
import com.sngular.domain.model.Movie

object MovieMapper: Mapper<MovieEntity, MovieDto, Movie> {
     override fun entityToModel(input: MovieEntity) = with(input){
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

    override fun dtoToModel(input: MovieDto) = with(input){
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

    override fun modelToEntity(input: Movie) = with(input){
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

     fun dtoToEntity(input: MovieDto) = with(input){
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