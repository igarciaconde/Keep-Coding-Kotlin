package com.example.gangameiigo.owned.viewModel

import androidx.lifecycle.ViewModel
import com.example.gangameiigo.model.CacheManager
import com.google.gson.JsonObject


class Owned :ViewModel(){

    private val cacheOwned = ArrayList<JsonObject>()


    init {
        val cache = CacheManager.getCacheOwned()
            .subscribe { elem ->
                val list = elem.entrySet().map { (key, json) ->
                    json.asJsonObject
                }
                cacheOwned.addAll(list)
            }
    }


    fun getCache() = cacheOwned

}