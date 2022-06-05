package com.example.f1calendarOP

import java.io.Serializable

    data class RaceResponse(
        val MRData: MRData
    )

    data class MRData(
        val RaceTable: RaceTable,
        val limit: String,
        val offset: String,
        val series: String,
        val total: String,
        val xmlns: String
    )

    data class RaceTable(
        val Races: List<Race>,
        val season: String
    )

    data class Race(
        val Circuit: Circuit,
        val FirstPractice: FirstPractice,
        val Qualifying: Qualifying,
        val SecondPractice: SecondPractice,
        val ThirdPractice: ThirdPractice,
        val Sprint: Sprint,
        val date: String,
        val raceName: String,
        val round: String,
        val season: String,
        val time: String,
        val url: String
    ) : Serializable

    data class Circuit(
        val Location: Location,
        val circuitId: String,
        val circuitName: String,
        val url: String
    )

    data class FirstPractice(
        val date: String,
        val time: String
    )

    data class Qualifying(
        val date: String,
        val time: String
    )

    data class SecondPractice(
        val date: String,
        val time: String
    )

    data class ThirdPractice(
        val date: String,
        val time: String
    )
    data class Sprint(
        val date: String,
        val time: String
    )

    data class Location(
        val country: String,
        val lat: String,
        val locality: String,
        val long: String
    )