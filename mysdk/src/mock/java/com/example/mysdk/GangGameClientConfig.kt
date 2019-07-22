package com.example.mysdk

import okhttp3.OkHttpClient
import retrofit2.Retrofit


class GangGameClientConfig : GangGameApiConfig{

    companion object {
        const val DEFAULT_RESPONSE = "{\"status\" : \"success\"}"
    }


    override fun setUp(builder: Retrofit.Builder) {
        val client : OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(MockResponseInterceptor(getResponses(), DEFAULT_RESPONSE))
            .build()

        builder.client(client)
    }

    fun getResponses() =
        hashMapOf(
            Pair(Routes.TOP_DEALS, MockResponses.DEAL_RESPONSE),
            Pair(Routes.TOP_OWNED, MockResponses.TOP_GAME_RESPONSE),
            Pair(Routes.TOP_100_GAMES, MockResponses.TOP_GAME_RESPONSE)
        )



}