package com.example.myfirstround.Container

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
//we need to make it as Dagger Hilt Container, so it will keep all the dependency with itself through out the application
class BaseApp: Application() {
}