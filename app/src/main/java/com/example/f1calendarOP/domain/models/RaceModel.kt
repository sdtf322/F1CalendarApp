package com.example.f1calendarOP.domain.models
import com.google.gson.annotations.SerializedName

    data class RaceModel(
        @SerializedName("Circuit")val circuit: Circuit,
        @SerializedName("FirstPractice")val firstPractice: FirstPractice,
        @SerializedName("Qualifying")val qualifying: Qualifying,
        @SerializedName("SecondPractice")val secondPractice: SecondPractice,
        @SerializedName("ThirdPractice")val thirdPractice: ThirdPractice? = null,
        @SerializedName("Sprint")val sprint: Sprint? = null,
        @SerializedName("date")var date: String,
        @SerializedName("raceName")val raceName: String,
        @SerializedName("round")val round: String,
        @SerializedName("season")val season: String,
        @SerializedName("time")val time: String,
        @SerializedName("url")val url: String,

        var flagImage: Int,
        var weekendDate : String,
    )

    data class Circuit(
            @SerializedName("Location")val location: Location,
            @SerializedName("circuitId")val circuitId: String,
            @SerializedName("circuitName")val circuitName: String,
            @SerializedName("url")val url: String
    )

    data class FirstPractice(
            @SerializedName("date")val date: String,
            @SerializedName("time")val time: String
        )

    data class Qualifying(
        @SerializedName("date")val date: String,
        @SerializedName("time")val time: String
    )

    data class SecondPractice(
            @SerializedName("date")val date: String,
            @SerializedName("time")val time: String
        )

    data class ThirdPractice(
            @SerializedName("date")val date: String,
            @SerializedName("time")val time: String
        )

    data class Sprint(
            @SerializedName("date")val date: String,
            @SerializedName("time")val time: String
        )

    data class Location(
            @SerializedName("country")val country: String,
            @SerializedName("lat")val lat: String,
            @SerializedName("locality")val locality: String,
            @SerializedName("long")val long: String
        )