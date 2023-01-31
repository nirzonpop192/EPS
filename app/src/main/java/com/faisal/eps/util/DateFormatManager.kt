package com.faisal.eps.util

import android.annotation.SuppressLint
import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class DateFormatManager {
    companion object{
        @SuppressLint("SimpleDateFormat")
        fun formatDateTime(rawData:String?):String?{
            val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.ssssss")
            val output = SimpleDateFormat("MMM dd, yyyy HH:mm aa")

            if (rawData==null)
                return ""

            var d: Date? = null
            try {
                d = input.parse(rawData)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            val formatted: String? = d?.let { output.format(it) }
            Log.i("DATE", "" + formatted)
            return formatted
        }
    }
}