package com.example.gangameiigo.model

import android.database.Observable
import com.example.mysdk.Deal
import com.example.mysdk.GangGameServiceApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.ScheduledExecutorService
import kotlin.Comparator
import kotlin.collections.ArrayList


object GangGameDataSource {

    private val apiService = GangGameServiceApi()

    fun getDeals(): io.reactivex.Observable<ArrayList<com.example.gangameiigo.model.Deal>> {
        return apiService.serviceApiClient
            .getDealsObservable()
            .map { listDeal ->
                val deals = listDeal.map { deal ->
                    DealMapper.fromSdk(deal) }
                val arrayDeal = arrayListOf<com.example.gangameiigo.model.Deal>()
                arrayDeal.addAll(deals)
                arrayDeal
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }


    fun getTopOwned(): io.reactivex.Observable<ArrayList<TopGame>> {
        return apiService.serviceApiClient
            .getOwnedObservable()
            .map { listOwned ->
                val owned = listOwned.mapIndexed { index, topGame ->
                    TopGameMapper.fromSdk(topGame, (index + 1))
                }
                val arrayOwned = arrayListOf<TopGame>()
                arrayOwned.addAll(owned)
                arrayOwned
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }


    fun getTopRated(): io.reactivex.Observable<ArrayList<TopGame>> {
        return apiService.serviceApiClient
            .getRatedObservable()
            .map { listRated ->
                listRated.sortWith(Comparator{ p0, p1 ->
                    when{
                        p0.steamRating > p1.steamRating -> -1
                        p0.steamRating == p1.steamRating -> 0
                        else -> 1
                    }
                })
                val rated = listRated.mapIndexed { index, topGame ->
                    TopGameMapper.fromSdk(topGame, (index + 1))
                }
                val arrayOwned = arrayListOf<TopGame>()
                arrayOwned.addAll(rated)
                arrayOwned
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

}