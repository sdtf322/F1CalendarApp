package com.example.f1calendarOP

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api : RaceApi by lazy{
        Retrofit.Builder()
            .baseUrl("http://ergast.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RaceApi::class.java)
    }
}