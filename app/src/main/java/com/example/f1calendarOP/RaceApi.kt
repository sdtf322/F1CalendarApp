package com.example.f1calendarOP

import com.example.f1calendarOP.domain.models.RaceResponse
import retrofit2.http.GET

interface RaceApi {

    @GET("/api/f1/current.json") // List of Race Schedule of Current Season
    suspend fun getRaceInfo(): RaceResponse
}