package com.example.mysdk

import com.example.mysdk.serializer.TopGameDeserializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.junit.Assert
import org.junit.Test

class ModelUnitTest{


    val JSON_DEAL= "{\n" +
            "        \"internalName\": \"MASSEFFECT2\",\n" +
            "        \"title\": \"Mass Effect 2\",\n" +
            "        \"metacriticLink\": \"/game/pc/mass-effect-2\",\n" +
            "        \"dealID\": \"uCVlnbipdD%2FqRz5YOMBvZ36t1%2Bxa1%2FzhK1ttPf9itXw%3D\",\n" +
            "        \"storeID\": \"1\",\n" +
            "        \"gameID\": \"72\",\n" +
            "        \"salePrice\": \"4.99\",\n" +
            "        \"normalPrice\": \"19.99\",\n" +
            "        \"isOnSale\": \"1\",\n" +
            "        \"savings\": \"75.037519\",\n" +
            "        \"metacriticScore\": \"94\",\n" +
            "        \"steamRatingText\": \"Overwhelmingly Positive\",\n" +
            "        \"steamRatingPercent\": \"95\",\n" +
            "        \"steamRatingCount\": \"9952\",\n" +
            "        \"steamAppID\": \"24980\",\n" +
            "        \"releaseDate\": 1264464000,\n" +
            "        \"lastChange\": 1563469340,\n" +
            "        \"dealRating\": \"9.5\",\n" +
            "        \"thumb\": \"https://steamcdn-a.akamaihd.net/steam/apps/24980/capsule_sm_120.jpg?t=1447352739\"\n" +
            "    }"

    val JSON_TOPGAMES = "{\n" +
            "        \"appid\": 10,\n" +
            "        \"name\": \"Counter-Strike\",\n" +
            "        \"developer\": \"Valve\",\n" +
            "        \"publisher\": \"Valve\",\n" +
            "        \"score_rank\": \"\",\n" +
            "        \"positive\": 133265,\n" +
            "        \"negative\": 3540,\n" +
            "        \"userscore\": 0,\n" +
            "        \"owners\": \"20,000,000 .. 50,000,000\",\n" +
            "        \"average_forever\": 10063,\n" +
            "        \"average_2weeks\": 240,\n" +
            "        \"median_forever\": 166,\n" +
            "        \"median_2weeks\": 33,\n" +
            "        \"price\": \"999\",\n" +
            "        \"initialprice\": \"999\",\n" +
            "        \"discount\": \"0\"\n" +
            "    }"



    @Test
    fun unitTestDeal(){
        val gson = Gson()
        val deal = gson.fromJson(JSON_DEAL, Deal::class.java)

        Assert.assertEquals(deal.title, "Mass Effect 2" )
        Assert.assertEquals(deal.metaRating,94)
        Assert.assertEquals(deal.steamRating, 95)
        Assert.assertEquals(deal.dealPrice, 4.99F)
        Assert.assertEquals(deal.orgPrice, 19.99F)
        Assert.assertEquals(deal.imageThumb, "https://steamcdn-a.akamaihd.net/steam/apps/24980/capsule_sm_120.jpg?t=1447352739")
    }

    @Test
    fun unitTestTopGame(){
        val gson = GsonBuilder()
            .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
            .create()
        val deal = gson.fromJson(JSON_TOPGAMES, TopGame::class.java)

        Assert.assertEquals(deal.title, "Counter-Strike" )
        Assert.assertEquals(deal.designer,"Valve")
        Assert.assertEquals(deal.steamRating, 10063)
        Assert.assertEquals(deal.getOwner(), "50,000,000")
        Assert.assertEquals(deal.price, 999F)
        Assert.assertEquals(deal.imageThumb,"https://steamcdn-a.akamaihd.net/steam/apps/10/capsule_184x69.jpg")

    }
}