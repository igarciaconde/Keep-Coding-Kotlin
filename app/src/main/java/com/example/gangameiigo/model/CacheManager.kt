package com.example.gangameiigo.model

import com.example.mysdk.GangGameServiceApi
import com.google.gson.JsonArray
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


object CacheManager {

    private val apiService = GangGameServiceApi()


    fun getCacheDeals(): io.reactivex.Observable<JsonArray> {
        return apiService.serviceCacheApiClient.getDealsCache()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }


    fun getCacheRated(): io.reactivex.Observable<JsonArray> {
        return apiService.serviceCacheApiClient.getRatedCache()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    fun getCacheOwned(): io.reactivex.Observable<JsonArray> {
        return apiService.serviceCacheApiClient.getOwnedCache()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }




}