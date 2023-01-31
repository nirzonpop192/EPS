package com.faisal.eps.data

data class OrderResponseItem(
    val address: Any,
    val bookingID: Int,
    val cd: String,
    val clientID: Int,
    val code: String,
    val compnayID: Int,
    val deliveryDate: String,
    val dueAmount: Int,
    val paidAmount: Int,
    val products: Any,
    val rOuteFK: Int,
    val remarks: Any,
    val shopFK: Int,
    val shopName: Any,
    val statusID: Int,
    val totalDiscount: Int,
    val totalItem: Int,
    val totalValue: Double,
    val typeID: Int,
    val userID: Int,
    val voucherID: Int
)