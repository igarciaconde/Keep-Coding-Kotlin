package com.example.gangameiigo.model

import com.google.gson.JsonObject


object TopGameMapper {

    const val BASE_IMG_URL = "https://steamcdn-a.akamaihd.net/steam/apps/%s/capsule_184x69.jpg"

    fun fromSdk(game : com.example.mysdk.TopGame, position: Int) :TopGame {
        return if(0 == game.price.compareTo(0.0))
            TopGame(game.title, game.imageThumb, game.steamRating/10,
                game.getOwner(), "Free", game.designer, position)

         else TopGame(game.title, game.imageThumb, game.steamRating/10,
            game.getOwner(), "$"+(game.price/100).toString(), game.designer, position)
    }

    /*fun fromCache(json : JsonObject) = TopGame(json["name"].asString, String.format(BASE_IMG_URL,json["appid"]), json["average_forever"].asInt,
        json["owners"].asInt, json["price"].asFloat, json["publisher"].asFloat)*/

}

