package com.faisal.eps.di

import android.util.Log
import com.faisal.eps.remote.EPSApi
import com.faisal.eps.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    private val TAG=ApiModule::class.java.name
    private const val BASE_URL="http://test.bdbizhub.com/Api/"

    @Provides
    @Singleton
    fun provideLogger (): HttpLoggingInterceptor {
        Log.e(TAG,"Logger create")
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideHttpClient(logger: HttpLoggingInterceptor): OkHttpClient {
        Log.e(TAG,"client create")
        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client:OkHttpClient): Retrofit {
        Log.e(TAG,"retrofit create")
        if (Constant.DEBUG_MODE) {

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()// do something for a debug build
        }
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Provides
    @Singleton
    fun provideGitHubApi(retrofit: Retrofit): EPSApi {
        return retrofit.create(EPSApi::class.java)
    }

}