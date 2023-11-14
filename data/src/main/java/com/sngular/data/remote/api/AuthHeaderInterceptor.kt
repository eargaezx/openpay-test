package com.sngular.data.remote.api

import com.sngular.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthHeaderInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .build()

        val requestBuilder = original.newBuilder()
            .header("Authorization", BuildConfig.AUTHORIZATION)
            .url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
