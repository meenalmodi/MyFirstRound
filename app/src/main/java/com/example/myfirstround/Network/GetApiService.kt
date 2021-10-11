package com.example.myfirstround.Network

import com.example.myfirstround.Model.Get
import retrofit2.http.GET

interface GetApiService  {

    @GET("questions?order=desc&sort=activity&site=stackoverflow")
    suspend fun get (): Get
}