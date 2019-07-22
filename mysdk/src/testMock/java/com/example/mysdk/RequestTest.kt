package com.example.mysdk


import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.junit.Assert
import org.junit.Test


class RequestTest {

    @Test
    fun dealRequest_Success(){
        val apiService  = GangGameServiceApi()
        val response = apiService.serviceApiClient.getDeals().execute()
        val deals = response.body()

        val parser = JsonParser()

        val jsonReponse = parser.parse(MockResponses.DEAL_RESPONSE).asJsonArray

        Assert.assertTrue(response.isSuccessful)
        deals?.let {
            Assert.assertEquals(deals.size, 4)
            deals.zip(jsonReponse).forEach { (deal, json)->
                with(json.asJsonObject){
                    Assert.assertEquals(deal.title, this["title"].asString)
                    Assert.assertEquals(deal.imageThumb, this["thumb"].asString)
                    Assert.assertEquals(deal.orgPrice, this["normalPrice"].asFloat)
                    Assert.assertEquals(deal.dealPrice, this["salePrice"].asFloat)
                }

            }
        }

    }


    @Test
    fun topGameRequest_Success(){
        val apiService  = GangGameServiceApi()
        val response = apiService.serviceApiClient.getOwned().execute()
        val games = response.body()

        val parser = JsonParser()

        val jsonReponse: List<JsonObject> = parser.parse(MockResponses.TOP_GAME_RESPONSE).asJsonObject
            .entrySet()
            .map { (_,json) ->
                json.asJsonObject
            }

        Assert.assertTrue(response.isSuccessful)
        games?.let {
            Assert.assertEquals(games.size, jsonReponse.size )
            games.zip(jsonReponse).forEach { (game, json)->
                with(json.asJsonObject){
                    Assert.assertEquals(game.title, this["name"].asString)
                    Assert.assertEquals(game.owners, this["owners"].asString)
                    Assert.assertEquals(game.steamRating, this["average_forever"].asInt)
                    Assert.assertEquals(game.imageThumb, "https://steamcdn-a.akamaihd.net/steam/apps/${this["appid"]}/capsule_184x69.jpg")
                }

            }
        }

    }




}