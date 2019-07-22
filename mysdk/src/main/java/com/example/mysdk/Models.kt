package com.example.mysdk

import com.google.gson.annotations.SerializedName

data class TopGame(
    @SerializedName("name") val title: String,
    var imageThumb: String,
    @SerializedName("average_forever") val steamRating: Int,
    val owners: String,
    val price: Float,
    @SerializedName("publisher") val designer: String){

    fun getOwner() = owners.dropWhile {  !it.isWhitespace()}.drop(4)
}


data class Deal(
    val title: String,
    @SerializedName("thumb") val imageThumb: String,
    @SerializedName("steamRatingPercent") val steamRating: Int,
    @SerializedName("metacriticScore") val metaRating: Int,
    @SerializedName("normalPrice") val orgPrice: Float,
    @SerializedName("salePrice") val dealPrice: Float)