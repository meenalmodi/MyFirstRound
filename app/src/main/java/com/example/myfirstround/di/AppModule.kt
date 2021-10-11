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

//this dependency will be valid throughout the application
//we have to create 3 dependencies - base url, retrofit builder dependency, GetApiService dependency
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

//    @Provides
//    fun providesBaseUrl():String = "https://api.stackexchange.com/2.3/"

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