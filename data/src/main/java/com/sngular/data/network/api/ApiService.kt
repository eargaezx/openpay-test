package com.sngular.data.network.api

import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("evaluation/student")
    suspend fun getStudentEvaluations(
        @Header("Authorization") jwt: String,
        @Query("matriculaId") enrollmentId: Long,
        @Query("bookingId") bookingId: Long?,
    ): Response<Void>

}