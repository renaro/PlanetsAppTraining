package com.example.planetsapptraining

import android.app.Application
import com.example.planetsapptraining.di.ApplicationComponent
import com.example.planetsapptraining.di.DaggerApplicationComponent

class App : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.create()
    }
}