package com.example.mysdk

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {

    @GET(Routes.TOP_DEALS)
    fun getDealsCache() : Observable<JsonArray>

    @GET(Routes.TOP_100_GAMES)
    fun getRatedCache(): Observable<JsonArray>

    @GET(Routes.TOP_OWNED)
    fun getOwnedCache() : Observable<JsonArray>

    @GET(Routes.TOP_DEALS)
    fun getDealsObservable() : Observable<ArrayList<Deal>>

    @GET(Routes.TOP_100_GAMES)
    fun getRatedObservable(): Observable<ArrayList<TopGame>>

    @GET(Routes.TOP_OWNED)
    fun getOwnedObservable() : Observable<ArrayList<TopGame>>
}