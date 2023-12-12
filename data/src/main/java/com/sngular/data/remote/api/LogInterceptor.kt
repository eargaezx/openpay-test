package com.sngular.data.remote.api

import android.util.Log
import com.sngular.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class LogInterceptor @Inject constructor() : Interceptor {
    companion object{
        const val LOGGING_REQUEST = "LOGGING_REQUEST_TAG"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val response = chain.proceed(request)

        if(BuildConfig.DEBUG){
            val responseString = response.body()?.string()
            Log.d(LOGGING_REQUEST, responseString?:"")
        }

        return  response
    }
}
