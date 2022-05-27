package com.example.f1calendarOP

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val gson : Gson = GsonBuilder()
        .setLenient()
        .create()

    val api : RaceApi by lazy{

        Retrofit.Builder()
            .baseUrl("http://ergast.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(RaceApi::class.java)
    }
}