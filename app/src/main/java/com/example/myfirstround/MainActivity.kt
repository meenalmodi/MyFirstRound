package com.example.myfirstround

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.myfirstround.ViewModel.GetViewModel
import dagger.hilt.android.AndroidEntryPoint

//"@AndroidEntryPoint" -- iska matlab jitni b dependency provide hui iss app k ander woh yaha main activity me use ker sakte hain
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val getViewModel:GetViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getViewModel.response.observe(this, Observer { response->
            Log.d("main","$response")
        })
    }
}