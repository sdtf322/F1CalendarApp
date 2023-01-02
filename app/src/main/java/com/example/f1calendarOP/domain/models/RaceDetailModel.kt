package com.example.f1calendarOP.domain.models

sealed class RaceDetailModel {
    data class Header(
        val flag: Int,
        val track: String,
        val date: String
    ) : RaceDetailModel()

    data class Session(
        val sessionDate: String,
        val sessionName: String,
        val sessionTime: String
    ) : RaceDetailModel()

    data class Circuit(
        val circuitImage: Int,
        val firstYear: Int,
        val laps: Int,
        val circuitLength: String,
        val raceDistance: String,
        val lapRecord: String,
        val lapRecordOwner: String
    ) : RaceDetailModel()
}