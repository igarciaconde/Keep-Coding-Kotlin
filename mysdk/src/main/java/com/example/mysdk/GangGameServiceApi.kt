package com.example.mysdk

import com.example.mysdk.serializer.ListTopGamesDeserializer
import com.example.mysdk.serializer.TopGameDeserializer
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GangGameServiceApi(val apiConfig: GangGameApiConfig = GangGameClientConfig()) {

    val serviceApiClient : RetrofitAPI

    init {
        val tokenType = object : TypeToken<ArrayList<TopGame>>(){}.type

        val gson = GsonBuilder()
            .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
            .registerTypeAdapter(tokenType, ListTopGamesDeserializer())
            .create()

        val serviceClientConfig = Retrofit.Builder()
            .baseUrl(Routes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))


        apiConfig.setUp(serviceClientConfig)

        serviceApiClient = serviceClientConfig.build().create(RetrofitAPI::class.java)
    }
}