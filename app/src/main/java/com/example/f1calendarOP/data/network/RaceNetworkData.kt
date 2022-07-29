package com.example.f1calendarOP.data.network

import com.example.f1calendarOP.data.models.Race
import com.example.f1calendarOP.data.models.RaceResponse
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.io.IOException

class RaceNetworkData {

    suspend fun getRaceListOfCurrSeason(): List<Race> {

        val deferredResponse : Deferred<RaceResponse>

        supervisorScope {
            deferredResponse =
                async(Dispatchers.IO)
                { RetrofitInstance.api.getRaceInfo() }

            try {
                deferredResponse.await()
            } catch (e: IOException) {
                println(e.message)
                return@supervisorScope
            } catch (e : HttpException) {
                println(e.message)
                return@supervisorScope
            }
        }

        val response = deferredResponse.await()

        return response.mrData.raceTable.races
    }
}
