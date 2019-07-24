package com.example.mysdk

import com.example.mysdk.serializer.ListTopGamesDeserializer
import com.example.mysdk.serializer.TopGameDeserializer
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GangGameServiceApi(val apiConfig: GangGameApiConfig = GangGameClientConfig(), val apiConfigCache: GangGameApiConfig = GangGameClientConfig()) {

    val serviceApiClient : RetrofitAPI

    val serviceCacheApiClient : RetrofitAPI

    init {
        val tokenType = object : TypeToken<ArrayList<TopGame>>(){}.type

        val gson = GsonBuilder()
            .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
            .registerTypeAdapter(tokenType, ListTopGamesDeserializer())
            .create()

        val serviceClientConfig = Retrofit.Builder()
            .baseUrl(Routes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())


        apiConfig.setUp(serviceClientConfig)

        serviceApiClient = serviceClientConfig.build().create(RetrofitAPI::class.java)


        ///init service cache

        val serviceClientCacheConfig = Retrofit.Builder()
            .baseUrl(Routes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

        apiConfigCache.setUp(serviceClientCacheConfig)
        serviceCacheApiClient = serviceClientCacheConfig.build().create(RetrofitAPI::class.java)

    }
}