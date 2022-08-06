package com.example.f1calendarOP.data.models

sealed class RaceDetail {
    data class Header(
        val flag : Int,
        val track : String,
        val date : String
    ) : RaceDetail()
    data class Session(
        val sessionDate: String,
        val sessionName : String,
        val sessionTime : String
    ) : RaceDetail()
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