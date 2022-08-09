package com.example.f1calendarOP.app

import android.app.Application
import com.example.f1calendarOP.di.AppComponent
import com.example.f1calendarOP.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()

//        appComponent = DaggerAppComponent.builder().appModule(AppModule()).build()
    }
}