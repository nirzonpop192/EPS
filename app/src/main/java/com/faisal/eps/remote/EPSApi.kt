package com.faisal.eps.remote

import com.faisal.eps.ShopRequestJson
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface EPSApi {



    @POST("App/Shop")
    suspend fun getRepository(
        @Body  body: ShopRequestJson,
        ): String
}