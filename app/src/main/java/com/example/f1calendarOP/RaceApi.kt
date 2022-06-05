package com.example.f1calendarOP

import retrofit2.Response
import retrofit2.http.GET

interface RaceApi {

    @GET("/api/f1/current.json") // List of Race Schedule of Current Season
    suspend fun getRaceInfo(): RaceResponse
}