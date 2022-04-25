package com.example.f1calendarOP

sealed class RaceDetailModel {
    data class Header(
        val flag : Int,
        val track : String,
        val date : String
    ) : RaceDetailModel()
    data class Session1(
        val sessionDate: String,
        val sessionName : String,
        val sessionTime : String
    ) : RaceDetailModel()
    data class Session2(
        val sessionDate : String,
        val sessionName : String,
        val sessionTime : String
    ) : RaceDetailModel()
    data class Session3(
        val sessionDate : String,
        val sessionName : String,
        val sessionTime : String
    ) : RaceDetailModel()
    data class Session4(
        val sessionDate : String,
        val sessionName : String,
        val sessionTime : String
    ) : RaceDetailModel()
    data class Session5(
        val sessionDate : String,
        val sessionName : String,
        val sessionTime : String
    ) : RaceDetailModel()
}