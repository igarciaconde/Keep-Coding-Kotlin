package com.example.mysdk

object Routes{

    const val BASE_URL = "https://steamspy.com/api.php/"

    const val CHEAP_SHARK_STEAM_STORE="1"

    const val BASE_ROUTE_STEAM_SPY = "https://steamspy.com/api.php"
    const val BASE_ROUTE_CHEAP_SHARK = "https://cheapshark.com/api/1.0"

    const val TOP_100_GAMES = BASE_ROUTE_STEAM_SPY + "?request=top100in2weeks"
    const val TOP_OWNED = BASE_ROUTE_STEAM_SPY + "?request=top100owned"
    const val TOP_DEALS = BASE_ROUTE_CHEAP_SHARK + "/deals?storeID=" + CHEAP_SHARK_STEAM_STORE

}