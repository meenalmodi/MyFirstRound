package com.example.myfirstround.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.myfirstround.Model.Get
import com.example.myfirstround.Model.Item
import com.example.myfirstround.Repository.GetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
//ViewModel is an external library do that means iski directly to dependency nahi provide kerwa sakte

//Flow is not Lifecycle aware, so we need to convert it to LiveData -
// means jaise hamari activity behave karegi waise hi hamara Live Data behavie karega, agar Activity destroy hogi toh Live data b destroy hoga
class GetViewModel @Inject
constructor(private val getRepository: GetRepository)
    : ViewModel() {

        val response: LiveData<List<Item>> = getRepository.get()
            .catch {
                e-> Log.d("main", "${e.message}")
            }.asLiveData()
}