package com.faisal.eps.local

import androidx.room.*
import com.faisal.eps.data.OrderResponseItem

@Dao
interface GitOrderDao {
    @Query("SELECT * FROM tbOrder")
    fun getOrders() : List<OrderResponseItem>

    @Query("SELECT * FROM tbOrder  WHERE bookingID LIKE '%' || :search || '%'")
    fun getOrders(search:String) : List<OrderResponseItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repositoryItem: OrderResponseItem) : Long

    @Delete
    suspend fun delete(repositoryItem: OrderResponseItem)

    @Query("DELETE FROM tbOrder")
    suspend fun deleteAll()
}