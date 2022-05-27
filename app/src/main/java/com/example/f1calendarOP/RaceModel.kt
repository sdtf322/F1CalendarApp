package com.example.f1calendarOP

data class RaceResponse(
    val raceF1Model : RaceF1Model
)

data class RaceF1Model(
    val Circuit: Circuit,
    val FirstPractice: FirstPractice,
    val Qualifying: Qualifying,
    val SecondPractice: SecondPractice,
    val ThirdPractice: ThirdPractice,
    val date: String,
    val raceName: String,
    val round: String,
    val season: String,
    val time: String,
    val url: String
)

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

data class Location(
    val country: String,
    val lat: String,
    val locality: String,
    val long: String
)