package com.faisal.eps.remote

import com.faisal.eps.data.ShopRequestJson
import com.faisal.eps.data.ShopResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface EPSApi {



    @POST("App/Shop")
    suspend fun getShop(
        @Body  body: ShopRequestJson,
        ): ShopResponse
}