package com.example.myfirstround.Repository

import android.util.Log
import com.example.myfirstround.Model.Item
import com.example.myfirstround.Network.GetServiceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class GetRepository
@Inject
constructor(private val getApiServiceImp: GetServiceImp) {
    val results = arrayListOf<Item>()

    fun get(): Flow<ArrayList<Item>> = flow {
        val response = getApiServiceImp.get()
        for(question in response.items)
            if (question.is_answered)
            if(question.accepted_answer_id != 0 && question.answer_count > 1) {
                results.add(question)
            }

        if(results.size==0) {
            Log.d("Response: ","There is no list of questions, which have 1)Accepted Answers and 2)More than one answer!!")
        }

        emit(results)
    }.flowOn(Dispatchers.IO)
}