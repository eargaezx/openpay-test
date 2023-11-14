package com.sngular.data.remote.api

import com.sngular.data.remote.response.MoviesResponse
import com.sngular.data.remote.response.PeopleImageResponse
import com.sngular.data.remote.response.PeopleResponse
import com.sngular.data.remote.response.ReviewResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("person/popular")
    suspend fun getPopularPeople(
        @Query("language") region: String? = "en-US",
    ): Response<PeopleResponse>

    @GET("person/{person_id}/images")
    suspend fun getPeopleImages(
        @Path("person_id") peopleId: Int,
        @Query("language") region: String? = "en-US",
    ): Response<PeopleImageResponse>

    @GET("movie/popular")
    suspend fun getAllMovies(
        @Query("page") page: Int,
        @Query("language") region: String? = "en-US",
    ): Response<MoviesResponse>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int,
        @Query("language") region: String? = "en-US",
    ): Response<MoviesResponse>

    @GET("movie/top_rated")
    suspend fun getTopMovies(
        @Query("page") page: Int,
        @Query("language") region: String? = "en-US",
    ): Response<MoviesResponse>

    @GET("movie/now_playing")
    suspend fun getSuggestedMovies(
        @Query("page") page: Int,
        @Query("language") region: String? = "en-US",
    ): Response<MoviesResponse>

    @GET("movie/575264/reviews")
    suspend fun getReviews(
        @Query("page") page: Int,
        @Query("language") region: String? = "en-US",
    ): Response<ReviewResponse>
}