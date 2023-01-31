package com.faisal.eps.data

data class ShopResponse(
    val address: Any,
    val code: Any,
    val confirm: Int,
    val date: String,
    val delivered: Int,
    val district: String,
    val districtID: Int,
    val latitude: Double,
    val longitude: Double,
    val orderID: Int,
    val partialDelivered: Int,
    val phoneNumber: String,
    val shopID: Int,
    val shopName: String,
    val statusID: Int,
    val thana: String,
    val thanaID: Int
) {

}