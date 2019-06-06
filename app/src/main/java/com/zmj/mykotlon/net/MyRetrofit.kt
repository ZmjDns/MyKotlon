package com.zmj.mykotlon.net

import com.zmj.mykotlon.config.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/5
 * Description :
 */
object MyRetrofit {

    private val client : OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
//        .sslSocketFactory(SSLSocketFactory.getDefault(),X509ExtendedKeyManager.)
        .build()

    val service :ApiService = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client).build()
        .create(ApiService::class.java)
}