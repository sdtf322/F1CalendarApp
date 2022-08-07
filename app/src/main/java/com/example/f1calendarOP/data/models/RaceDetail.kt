package com.example.f1calendarOP.data.models

sealed class RaceDetail {
    data class Circuit(
        val circuitImage: Int,
        val firstYear: Int,
        val laps: Int,
        val circuitLength: String,
        val raceDistance: String,
        val lapRecord: String,
        val lapRecordOwner: String
    ) : RaceDetail()
}