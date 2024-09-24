package com.android.goally.data.network.rest

import android.content.Context
import com.android.goally.util.AppUtil
import com.android.goally.util.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor(
    context: Context
) : Interceptor {

    private val applicationContext = context.applicationContext

    @Throws(NoInternetException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!AppUtil.isInternetAvailable(applicationContext)) throw NoInternetException(com.android.goally.constants.AppConstant.INTERNET_ERROR)
        return chain.proceed(chain.request())
    }


}