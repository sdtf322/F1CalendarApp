package com.example.f1calendarOP.domain.usecases

import com.example.f1calendarOP.domain.models.RaceModel
import com.example.f1calendarOP.domain.repository.RaceRepository
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat
import java.time.ZoneOffset
import java.util.*

class NotifyUserAboutRaceUseCase (
    private val raceRepository: RaceRepository) {


    fun getList () : List<RaceModel> {

        var repositoryRaceList: List<RaceModel>

        runBlocking {
            repositoryRaceList = raceRepository.getRaceList()

            for(item in repositoryRaceList) {
                item.time = changeTimeByTimeZone(item.time)
            }
        }

        return repositoryRaceList

        // returns a whole race list with time synchronized with user time zone
    }

    //Can be added as a separate use case

    private fun changeTimeByTimeZone(raceTime: String): String {
        val timeInputFormatter = SimpleDateFormat("HH:mm:ss'Z'", Locale.ENGLISH)
        val parsedTime = timeInputFormatter.parse(raceTime)

        val tzCalendar = Calendar.getInstance(TimeZone.getDefault())
        val timeZoneOffset = ((tzCalendar.get(Calendar.ZONE_OFFSET) +
                tzCalendar.get(Calendar.DST_OFFSET)) / (3600 * 1000)) // Difference in Hours (3)

        parsedTime.hours = parsedTime.hours + timeZoneOffset

        return timeInputFormatter.format(parsedTime)
    }

}