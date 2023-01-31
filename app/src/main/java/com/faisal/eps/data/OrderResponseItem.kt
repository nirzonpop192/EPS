package com.faisal.eps.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tbOrder")
@Parcelize
data class OrderResponseItem(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val address: String?,
    val bookingID: Int?,
    val cd: String?,
    val clientID: Int?,
    val code: String?,
    val compnayID: Int?,
    val deliveryDate: String?,
    val dueAmount: Int?,
    val paidAmount: Int?,
    val products: String?,
    val rOuteFK: Int?,
    val remarks: String?,
    val shopFK: Int?,
    val shopName: String?,
    val statusID: Int?,
    val totalDiscount: Int?,
    val totalItem: Int?,
    val totalValue: Double?,
    val typeID: Int?,
    val userID: Int?,
    val voucherID: Int?
): Parcelable {
    constructor() : this(
        0,
        "", 0,
        "",
        0,
        "",
        0,
        "",
        0,
        0,
        "",
        0,
        "",
        0,
        "",
        0,
        0,
        0,
        0.0,
        0,
        0,
        0
    )
}


