package com.faisal.eps.repository

import com.faisal.eps.data.ShopRequestJson
import com.faisal.eps.data.ShopResponse
import com.faisal.eps.remote.EPSApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(
    private val api:EPSApi,

) {
    companion object{
        private const val TAG="HomeRepository"
    }

    suspend fun fetchShopApi(body: ShopRequestJson): ShopResponse {
        return api.getShop(body)
    }















}