package com.example.f1calendarOP.domain.usecases

import java.text.SimpleDateFormat
import java.util.*

class FormatWeekendTimeUseCase {

    operator fun invoke(raceTime: String): String { // Detail screen

        val timeInputFormatter = SimpleDateFormat("HH:mm:ss'Z'", Locale.ENGLISH)
        val timeOutputFormatter = SimpleDateFormat("HH:mm", Locale.ENGLISH)
        val parsedTime = timeInputFormatter.parse(raceTime) // 12:00 (Date)

        val abobaCalendar = Calendar.getInstance(TimeZone.getDefault())
        val timeZoneOffset = ((abobaCalendar.get(Calendar.ZONE_OFFSET) +
                abobaCalendar.get(Calendar.DST_OFFSET)) / (3600 * 1000)) // Difference in Hours (3)

        parsedTime.hours = parsedTime.hours + timeZoneOffset

        return timeOutputFormatter.format(parsedTime)

    }
    }