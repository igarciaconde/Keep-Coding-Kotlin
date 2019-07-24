package com.example.gangameiigo.owned.viewModel

import androidx.lifecycle.ViewModel
import com.example.gangameiigo.model.CacheManager
import com.google.gson.JsonArray
import com.google.gson.JsonObject

class Owned :ViewModel(){

    private val cacheOwned = JsonArray()

    init {
        CacheManager.getCacheOwned()
            .subscribe { list ->
                list.map { elem ->
                    cacheOwned.add(elem)
                }
            }
    }

    fun getCache(): ArrayList<JsonObject> {
        val list = arrayListOf<JsonObject>()
        cacheOwned.map { elem ->
            list.add(elem.asJsonObject)
        }
        return list
    }
}