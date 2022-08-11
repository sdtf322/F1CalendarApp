package com.example.f1calendarOP.app

import android.app.Application
import com.example.f1calendarOP.di.*


class App : Application() {

    var appComponent: AppComponent = DaggerAppComponent.create()

}