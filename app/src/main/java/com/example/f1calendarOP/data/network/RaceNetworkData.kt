package com.example.f1calendarOP.data.network

import com.example.f1calendarOP.data.models.Race
import com.example.f1calendarOP.data.models.RaceResponse
import javax.inject.Inject

class RaceNetworkData @Inject constructor() : RaceApi {

    override suspend fun getRaceInfo(): RaceResponse {

        return RetrofitInstance.api.getRaceInfo()
    }

    override suspend fun getRaceList(): List<Race> {

        val raceResponse = getRaceInfo()

        return raceResponse.mrData.raceTable.races
    }
}
