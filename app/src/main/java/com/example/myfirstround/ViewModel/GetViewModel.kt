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

class GetViewModel @Inject
constructor(private val getRepository: GetRepository)
    : ViewModel() {

        val response: LiveData<List<Item>> = getRepository.get()
            .catch {
                e-> Log.d("main", "${e.message}")
            }.asLiveData()
}