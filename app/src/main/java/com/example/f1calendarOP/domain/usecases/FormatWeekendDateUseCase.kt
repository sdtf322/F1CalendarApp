package com.example.f1calendarOP.domain.usecases

import com.example.f1calendarOP.domain.models.RaceModel
import java.text.SimpleDateFormat
import java.util.*

class FormatWeekendDateUseCase {

    fun setListDate(race: RaceModel): String {

        val firstSessionDate = formatDetailDate(race.firstPractice.date)
        val lastSessionDate = formatDetailDate(race.date)

        return "$firstSessionDate - $lastSessionDate"
    }

    fun formatDetailDate(raceDate: String): String {

        val inputFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        val outputFormatter = SimpleDateFormat("dd-MMMM", Locale.ENGLISH)
        val givenDate = inputFormatter.parse(raceDate)

        return outputFormatter.format(givenDate)
    }

}