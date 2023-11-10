package com.sngular.domain.common

/*
*@Result Class that encapsule the state of the Flow result
 */
sealed class Result<out T>(val data: T? = null, val message: String? = null) {

    class Success<T>(data: T): Result<T>(data)
    class Error<T>(message: String, data: T? = null): Result<T>(data, message)
    class Loading<T>(data: T? = null): Result<T>(data)

}
