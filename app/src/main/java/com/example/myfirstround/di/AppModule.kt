package com.example.myfirstround.di

import com.example.myfirstround.Network.GetApiService
import com.example.myfirstround.Utils.Constants
import dagger.Module
import dagger.hilt.InstallIn
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton //singleton instance use hoga puri application k ander
    fun providesRetrofitBuilder() : Retrofit =
        Retrofit.Builder().
                baseUrl(Constants.BaseUrl).
                addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    fun providesGetApiService(retrofit: Retrofit) : GetApiService =
        retrofit.create(GetApiService::class.java)
}