package com.example.mysdk

import com.example.mysdk.serializer.TopGameDeserializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GangGameServiceApi {

    val serviceApi : RetrofitAPI

    init {
        val gson = GsonBuilder()
            .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
            .create()

        val serviceClient = Retrofit.Builder()
            .baseUrl(Routes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        serviceApi = serviceClient.create(RetrofitAPI::class.java)
    }
}