package com.example.gangameiigo.model

object DealMapper {


    fun fromSdk(deal : com.example.mysdk.Deal)
            = Deal(deal.title,
        deal.imageThumb,
        deal.steamRating,
        deal.metaRating,
        deal.orgPrice,
        deal.dealPrice)
}