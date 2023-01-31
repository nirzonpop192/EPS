package com.faisal.eps.util


import org.junit.Test

class DateFormatManagerTest{

    @Test
    fun `valid`(){
        DateFormatManager.formatDateTime("2022-09-07T20:31:13.185782")
    }
}
