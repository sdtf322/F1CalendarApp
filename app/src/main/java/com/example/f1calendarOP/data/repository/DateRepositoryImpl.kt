package com.example.f1calendarOP.data.repository

import com.example.f1calendarOP.domain.models.RaceModel
import com.example.f1calendarOP.domain.repository.DateRepository
import java.text.SimpleDateFormat
import java.util.*

class DateRepositoryImpl : DateRepository {

    override fun formatWeekendDate(race : RaceModel): String { // List and detail screen

        val firstSessionDate = formatDate(race.firstPractice.date)
        val lastSessionDate = formatDate(race.date)

        return "$firstSessionDate - $lastSessionDate"
    }

    private fun formatDate(raceDate: String): String { // Detail screen

        val inputFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        val outputFormatter = SimpleDateFormat("dd-MMMM", Locale.ENGLISH)
        val givenDate = inputFormatter.parse(raceDate)

        return outputFormatter.format(givenDate)
    }
}