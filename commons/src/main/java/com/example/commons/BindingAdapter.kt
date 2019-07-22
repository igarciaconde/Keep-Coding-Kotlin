package com.example.commons

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun setImage(image: ImageView, urlThumb: String){
        Glide.with(image)
            .load(urlThumb)
            .into(image)
}