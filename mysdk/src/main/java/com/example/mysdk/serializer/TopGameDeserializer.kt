package com.example.mysdk.serializer


import com.example.mysdk.TopGame
import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class TopGameDeserializer : JsonDeserializer<TopGame>{


    companion object{
        const val BASE_IMG_URL = "https://steamcdn-a.akamaihd.net/steam/apps/%s/capsule_184x69.jpg"
    }

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): TopGame {
        val gson = Gson()
        val topgame = gson.fromJson(json,TopGame::class.java)

        val appid = json.asJsonObject["appid"]
        topgame.imageThumb = String.format(BASE_IMG_URL,appid)

        return topgame
    }


}