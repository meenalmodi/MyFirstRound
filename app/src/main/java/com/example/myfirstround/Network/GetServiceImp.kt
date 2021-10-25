package com.example.myfirstround.Network

import com.example.myfirstround.Model.Get
import javax.inject.Inject

class GetServiceImp @Inject constructor(private val getServiceImp: GetApiService) {

    suspend fun get(): Get = getServiceImp.get()
}