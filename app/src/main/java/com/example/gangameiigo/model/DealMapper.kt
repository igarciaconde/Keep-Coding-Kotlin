package com.example.gangameiigo.model

import com.google.gson.JsonObject

object DealMapper {


    fun fromSdk(deal : com.example.mysdk.Deal)
            = Deal(deal.title,
        deal.imageThumb,
        deal.steamRating,
        deal.metaRating,
        deal.orgPrice,
        deal.dealPrice)


    fun fromCache(json : JsonObject) = Deal(json["title"].asString, json["thumb"].asString, json["steamRatingPercent"].asInt,
        json["metacriticScore"].asInt, json["normalPrice"].asFloat, json["salePrice"].asFloat)
}