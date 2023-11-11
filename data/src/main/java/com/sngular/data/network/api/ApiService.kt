package com.sngular.data.network.api

import com.sngular.data.network.dto.MovieDto
import com.sngular.data.network.response.MoviesResponse
import com.sngular.domain.model.Movie
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("trending/all/day?language=en-US")
    suspend fun getAllMovies(
        @Header("Authorization") jwt: String,
        @Header("accept") type: String = "application/json"
        //@Query("matriculaId") enrollmentId: Long,
        //@Query("bookingId") bookingId: Long?,
    ): Response<MoviesResponse>

}