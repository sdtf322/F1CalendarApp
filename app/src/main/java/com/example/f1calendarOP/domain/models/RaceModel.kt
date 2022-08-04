package com.example.f1calendarOP.domain.models

    data class RaceModel(
        val circuit: Circuit,
        val firstPractice: FirstPractice,
        val qualifying: Qualifying,
        val secondPractice: SecondPractice,
        val thirdPractice: ThirdPractice? = null,
        val sprint: Sprint? = null,
        var date: String,
        val raceName: String,
        val round: String,
        val season: String,
        val time: String,
        val url: String,
        var flagImage: Int,
        var weekendDate : String,
    )

    data class Circuit(
        val location: Location,
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