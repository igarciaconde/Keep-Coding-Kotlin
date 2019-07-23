package com.example.gangameiigo.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.commons.*
import com.squareup.picasso.Picasso

object PriceFormater{

    val FORMAT_PRICE = "$%2f"

    fun priceFormat(price : Float) = String.format(FORMAT_PRICE,price)




}

data class Deal(var title : String,
                var imageThumb: String,
                var steamRating : Int,
                var metaRating : Int,
                var orgPrice : Float,
                var dealPrice : Float) {

    val orgPriceFormatted: String
        get() = PriceFormater.priceFormat(orgPrice)

    val dealPriceFormatted: String
        get() = PriceFormater.priceFormat(dealPrice)



}


data class TopGame(var title: String,
                   var imageThumb: String,
                   var steamRating: Int,
                   var owners: String,
                   var price: String,
                   var designer: String,
                   var position: Int)
