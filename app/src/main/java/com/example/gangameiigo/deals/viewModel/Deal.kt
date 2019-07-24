package com.example.gangameiigo.deals.viewModel

import androidx.lifecycle.ViewModel
import com.example.gangameiigo.model.CacheManager
import com.google.gson.JsonArray
import com.google.gson.JsonObject

class Deal : ViewModel() {

    private val cacheDeals = JsonArray()

    init {
            CacheManager.getCacheDeals()
                .subscribe { list ->
                    list.map { elem ->
                        cacheDeals.add(elem)
                    }
                }
    }

    fun getCache(): ArrayList<JsonObject> {
        val list = arrayListOf<JsonObject>()
        cacheDeals.map { elem ->
            list.add(elem.asJsonObject)
        }
        return list
    }
}