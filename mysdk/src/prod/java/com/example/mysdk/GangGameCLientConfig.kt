package com.example.mysdk

import retrofit2.Retrofit

class GangGameClientConfig : GangGameApiConfig{

    //Just to fit the code and resolve dependencies between mock and prod
    override fun setUp(builder: Retrofit.Builder) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}