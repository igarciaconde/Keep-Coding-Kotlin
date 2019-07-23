package com.example.mysdk

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {

    @GET(Routes.TOP_DEALS)
    fun getDeals() : Call<ArrayList<Deal>>

    @GET(Routes.TOP_100_GAMES)
    fun getRated(): Call<ArrayList<TopGame>>

    @GET(Routes.TOP_OWNED)
    fun getOwned() : Call<ArrayList<TopGame>>

    @GET(Routes.TOP_DEALS)
    fun getDealsObservable() : Observable<ArrayList<Deal>>

    @GET(Routes.TOP_100_GAMES)
    fun getRatedObservable(): Observable<ArrayList<TopGame>>

    @GET(Routes.TOP_OWNED)
    fun getOwnedObservable() : Observable<ArrayList<TopGame>>
}