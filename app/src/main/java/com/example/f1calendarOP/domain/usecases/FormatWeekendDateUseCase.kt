package com.example.f1calendarOP.domain.usecases

import com.example.f1calendarOP.domain.models.RaceModel
import java.text.SimpleDateFormat
import java.util.*

class FormatWeekendDateUseCase {

    operator fun invoke(race : RaceModel): String {

        val firstSessionDate = formatDate(race.firstPractice.date)
        val lastSessionDate = formatDate(race.date)

        return "$firstSessionDate - $lastSessionDate"
    }

    private fun formatDate(raceDate: String): String {

        val inputFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        val outputFormatter = SimpleDateFormat("dd-MMMM", Locale.ENGLISH)
        val givenDate = inputFormatter.parse(raceDate)

        return outputFormatter.format(givenDate)
    }
}