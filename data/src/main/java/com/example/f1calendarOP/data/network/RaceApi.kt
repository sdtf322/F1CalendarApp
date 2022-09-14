package com.example.f1calendarOP.data.network

import com.example.f1calendarOP.data.models.Race
import com.example.f1calendarOP.data.models.RaceResponse
import retrofit2.http.GET

interface RaceApi {

    @GET("/api/f1/current.json") // List of Race Schedule of Current Season
    suspend fun getRaceInfo(): RaceResponse

    suspend fun getRaceList() : List<Race>

}