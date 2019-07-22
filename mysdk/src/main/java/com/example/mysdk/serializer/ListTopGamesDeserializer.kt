package com.example.mysdk.serializer

import com.example.mysdk.TopGame
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class ListTopGamesDeserializer : JsonDeserializer<ArrayList<TopGame>> {

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): ArrayList<TopGame> {
        val jsonTopGames =
            json.asJsonObject
                .entrySet().map { (key, json) ->
                    json.asJsonObject
                }

        val gson = GsonBuilder()
            .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
            .create()

        val listTopGames = jsonTopGames.map { json->
            gson.fromJson(json,TopGame::class.java)
        }
        val list = arrayListOf<TopGame>()
        list.addAll(listTopGames)

        return list
    }

}