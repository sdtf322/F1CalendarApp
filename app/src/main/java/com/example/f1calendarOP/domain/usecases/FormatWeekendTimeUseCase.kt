package com.example.f1calendarOP.domain.usecases

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class FormatWeekendTimeUseCase {

        operator fun invoke(raceTime: String): String { // Detail screen

            val timeInputFormatter = SimpleDateFormat("HH:mm:ss'Z'", Locale.ENGLISH)
            val timeOutputFormatter = SimpleDateFormat("HH:mm", Locale.ENGLISH)
            val parsedTime = timeInputFormatter.parse(raceTime)

            val tzCalendar = Calendar.getInstance(TimeZone.getDefault())
            val timeZoneOffset = ((tzCalendar.get(Calendar.ZONE_OFFSET) +
                    tzCalendar.get(Calendar.DST_OFFSET)) / (3600 * 1000)) // Difference in Hours (3)

            parsedTime.hours = parsedTime.hours + timeZoneOffset

            return timeOutputFormatter.format(parsedTime)

        }
}