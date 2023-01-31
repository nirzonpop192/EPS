package com.faisal.eps.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.faisal.eps.ApplicationScope
import com.faisal.eps.data.OrderResponseItem
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider


@Database(version = 2, entities = [OrderResponseItem::class])
//@TypeConverters(DataConverter::class)
abstract class EPSDataBase : RoomDatabase() {


    abstract fun  getGitRepositoryDao():GitOrderDao


    class Callback @Inject constructor(
        private val database: Provider<EPSDataBase>
        ,@ApplicationScope private val applicationScope: CoroutineScope
    ):RoomDatabase.Callback()

}