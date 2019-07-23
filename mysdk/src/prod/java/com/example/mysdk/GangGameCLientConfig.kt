package com.example.mysdk

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class GangGameClientConfig : GangGameApiConfig{

    //Just to fit the code and resolve dependencies between mock and prod
    override fun setUp(builder: Retrofit.Builder) {
        val okHttp = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()
        builder.client(okHttp)
    }

}