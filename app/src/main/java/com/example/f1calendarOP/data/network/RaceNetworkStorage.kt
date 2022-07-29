package com.example.f1calendarOP.data.network

import com.example.f1calendarOP.data.DateFormatter
import com.example.f1calendarOP.data.RaceStorageInterface
import com.example.f1calendarOP.data.models.Race
import com.example.f1calendarOP.data.storage.FlagStorage

private val raceNetworkData by lazy { RaceNetworkData() }
private val flagStorage by lazy { FlagStorage() }
private val dateFormatter by lazy { DateFormatter() }

class RaceNetworkStorage : RaceStorageInterface {

    override suspend fun getRaceList(): List<Race> {

        val mutableRaceList : List<Race> = raceNetworkData.getRaceListOfCurrSeason()
        
        for(item in mutableRaceList){
            item.flagImage = flagStorage.getFlagByCountry(item)
            item.weekendDate = dateFormatter.getWeekendDate(item)
        }

        return mutableRaceList
    }
}