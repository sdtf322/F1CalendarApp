package com.example.f1calendarOP.domain.usecases

import java.text.SimpleDateFormat
import java.util.*

class FormatWeekendTimeUseCase {

        operator fun invoke(raceTime: String): String { // Detail screen

            val timeInputFormatter = SimpleDateFormat("HH:mm:ss'Z'", Locale.ENGLISH)
            val timeOutputFormatter = SimpleDateFormat("HH:mm", Locale.ENGLISH)
            val parsedTime = timeInputFormatter.parse(raceTime)

            return timeOutputFormatter.format(parsedTime)

        }
    }