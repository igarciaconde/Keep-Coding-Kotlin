package com.example.gangameiigo.rated.viewModel

import androidx.lifecycle.ViewModel
import com.example.gangameiigo.model.CacheManager
import com.google.gson.JsonObject

class Rated : ViewModel(){

    private val cacheRated = ArrayList<JsonObject>()


    init {
        val subscribe = CacheManager.getCacheOwned()
            .subscribe { elem ->
                val list = elem.entrySet().map { (key, json) ->
                    json.asJsonObject
                }
                cacheRated.addAll(list)
            }
    }


    fun getCache() = cacheRated
}