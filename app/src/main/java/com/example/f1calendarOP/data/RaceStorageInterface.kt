package com.example.f1calendarOP.data

import com.example.f1calendarOP.data.models.Race

interface RaceStorageInterface {

    suspend fun getRaceListFromApi() : List<Race>

}