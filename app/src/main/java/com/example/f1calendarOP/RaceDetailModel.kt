package com.example.f1calendarOP

sealed class RaceDetailModel {
    data class Header(
        val flag : Int,
        val track : String,
        val date : String
    ) : RaceDetailModel()
    data class Session(
        val sessionDate: String,
        val sessionName : String,
        val sessionTime : String
    ) : RaceDetailModel()
    data class Circuit(
        val circuitImage: Int,
        val circuitFirstYear: String,
        val lapsNumber: Int,
        val circuitLength: String,
        val totalRaceDistance: String,
        val circuitLapRecord : String,
        val circuitLapRecordOwner: String
    ) : RaceDetailModel()
}