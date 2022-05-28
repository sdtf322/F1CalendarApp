package com.example.f1calendarOP

import retrofit2.Response
import retrofit2.http.GET

interface RaceApi {

    @GET("/api/f1/2022.json") // List of Race Schedule of Current Season
    suspend fun getRaceInfo(): Response<MRData> // What we expect
}