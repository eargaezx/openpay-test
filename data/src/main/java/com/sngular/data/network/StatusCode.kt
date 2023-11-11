package com.sngular.data.network

enum class StatusCode(val code: Int){
    SUCCESS(200),
    UNAUTHORIZED(401),
    BAD_REQUEST(400)
}