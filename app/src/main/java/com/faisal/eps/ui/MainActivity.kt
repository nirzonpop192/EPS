package com.faisal.eps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.faisal.eps.util.NetworkManager
import com.faisal.eps.R
import com.faisal.eps.util.Constant
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // Constant.SORT_BY= Constant.DATE
        Constant.IS_NETWORK_AVAILABLE= NetworkManager.isNetConnectionAvailable(this)
    }
}