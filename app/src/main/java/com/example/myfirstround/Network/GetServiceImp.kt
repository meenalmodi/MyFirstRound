package com.example.myfirstround.Network

import com.example.myfirstround.Model.Get
import javax.inject.Inject

//we have provided the dependency of "GetServiceImp" but we still have to provide the dependency of "GetServiceImp"
class GetServiceImp @Inject constructor(private val getServiceImp: GetApiService) {

    //suspend fun always calls suspend function
    suspend fun get(): Get = getServiceImp.get()
}