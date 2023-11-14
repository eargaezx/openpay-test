package com.sngular.domain.state

/*
*@Result Class that encapsule the state of the Flow result
 */
sealed class Result<out T>(val data: T? = null, val message: String? = null) {

    class Success<T>(data: T): Result<T>(data)
    class Error<T>(message: String, data: T? = null): Result<T>(data, message)
    class Loading<T>(data: T? = null): Result<T>(data)



    sealed class ErrorType(
        val throwable: Throwable? = null,
        val message: Int? = null
    ) {
        class DatabaseError(throwable: Throwable? = null) : ErrorType(throwable)
        class IOError(throwable: Throwable? = null) : ErrorType(throwable)
        class HttpError(throwable: Throwable? = null, val statusCode: Int) : ErrorType(throwable)
        class Unknown(throwable: Throwable? = null) : ErrorType(throwable)
    }
}
