package com.example.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.squareup.picasso.Picasso




fun ViewGroup.inflate(resId: Int, attachedToRoot: Boolean = false): View = LayoutInflater.from(context).inflate(resId, this, attachedToRoot)

fun NavigationView.selectOption(resId : Int) = findViewById<BottomNavigationView>(resId)

