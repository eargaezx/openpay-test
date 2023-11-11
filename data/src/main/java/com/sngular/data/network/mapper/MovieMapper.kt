package com.sngular.data.network.mapper

import com.sngular.data.network.dto.MovieDto
import com.sngular.domain.model.Movie

class MovieMapper : Mapper<MovieDto, Movie>{
    override fun mapToEntity(input: MovieDto) = Movie(
        title = input.title,
        posterPath = input.posterPath,
        voteAverage = input.voteAverage,
        voteCount = input.voteCount
    )
}