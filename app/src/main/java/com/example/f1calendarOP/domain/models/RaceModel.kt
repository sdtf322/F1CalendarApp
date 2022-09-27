package com.example.f1calendarOP.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

    @Parcelize
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
        var time: String,
        val url: String,
        var flagImage: Int? = null,
        var weekendDate : String? = null,
    ) : Parcelable

    @Parcelize
    data class Circuit(
        val location: Location,
        val circuitId: String,
        val circuitName: String,
        val url: String
    ) : Parcelable

    @Parcelize
    data class FirstPractice(
        val date: String,
        val time: String
    ) : Parcelable

    @Parcelize
    data class Qualifying(
        val date: String,
        val time: String
    ) : Parcelable

    @Parcelize
    data class SecondPractice(
        val date: String,
        val time: String
    ) : Parcelable

    @Parcelize
    data class ThirdPractice(
        val date: String,
        val time: String
    ) : Parcelable

    @Parcelize
    data class Sprint(
        val date: String,
        val time: String
    ) : Parcelable

    @Parcelize
    data class Location(
        val country: String,
        val lat: String,
        val locality: String,
        val long: String
    ) : Parcelable