package com.faisal.eps.repository

import android.util.Log
import com.faisal.eps.data.*
import com.faisal.eps.local.GitOrderDao
import com.faisal.eps.remote.EPSApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(
    private val api:EPSApi,
    private  val repositoryDao: GitOrderDao,
) {
    companion object{
        private const val TAG="HomeRepository"
    }

    suspend fun fetchShopApi(body: ShopRequestJson): ShopResponse {
        return api.getShop(body)
    }

    suspend fun fetchOrderApi(body: OrderRequestJson): OrderResponse {
        return api.getOrder(body)
    }
    suspend fun insertRepository(repository: OrderResponseItem){
        val  row=repositoryDao.insert(repository)
        Log.e(TAG, "row effected $row")
    }

     fun getOrder(id: String): List<OrderResponseItem>{
        return repositoryDao.getOrders(id)
       // Log.e(TAG, "row effected $row")
    }

















}