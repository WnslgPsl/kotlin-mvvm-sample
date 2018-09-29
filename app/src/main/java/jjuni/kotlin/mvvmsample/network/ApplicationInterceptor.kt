package jjuni.kotlin.mvvmsample.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Jo on 2018. 9. 29.
 */

class ApplicationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
                // .addHeader("서버와 약속된 헤더네임", "")
                .build()
        val response = chain.proceed(newRequest)
        return response
    }

}