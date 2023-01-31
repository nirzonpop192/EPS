package com.faisal.eps.di

import android.app.Application
import androidx.room.Room
import com.faisal.eps.local.EPSDataBase
import com.faisal.eps.local.GitOrderDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    companion object{
        private const val DATA_BASE_NAME="eps.sqlite3"
    }

    @Provides
    @Singleton
    fun provideDatabase(application: Application, callback: EPSDataBase.Callback):EPSDataBase{
        return Room.databaseBuilder(application,EPSDataBase::class.java,DATA_BASE_NAME)
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideGitRepositoryDoa(database:EPSDataBase): GitOrderDao {
        return database.getGitRepositoryDao()
    }


}
