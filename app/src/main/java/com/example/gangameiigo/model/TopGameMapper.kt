package com.example.gangameiigo.model


object TopGameMapper {

    fun fromSdk(game : com.example.mysdk.TopGame, position: Int) :TopGame {
        return if(0 == game.price.compareTo(0.0))
            TopGame(game.title, game.imageThumb, game.steamRating/10,
                game.getOwner(), "Free", game.designer, position)

         else TopGame(game.title, game.imageThumb, game.steamRating/10,
            game.getOwner(), "$"+(game.price/100).toString(), game.designer, position)
    }

}

