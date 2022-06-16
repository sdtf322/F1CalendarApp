package com.example.f1calendarOP

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

    data class RaceResponse(
        @SerializedName("MRData")val mrData: MRData
    )

    data class MRData(
        @SerializedName("RaceTable")val raceTable: RaceTable,
        @SerializedName("limit")val limit: String,
        @SerializedName("offset")val offset: String,
        @SerializedName("series")val series: String,
        @SerializedName("total")val total: String,
        @SerializedName("xmlns")val xmlns: String
    )

    data class RaceTable(
        @SerializedName("Races")val races: List<Race>,
        @SerializedName("season")val season: String
    )

    data class Race(
        @SerializedName("Circuit")val circuit: Circuit,
        @SerializedName("FirstPractice")val firstPractice: FirstPractice,
        @SerializedName("Qualifying")val qualifying: Qualifying,
        @SerializedName("SecondPractice")val secondPractice: SecondPractice,
        @SerializedName("ThirdPractice")val ThirdPractice: ThirdPractice,
        @SerializedName("Sprint")val sprint: Sprint,
        @SerializedName("date")var date: String,
        @SerializedName("raceName")val raceName: String,
        @SerializedName("round")val round: String,
        @SerializedName("season")val season: String,
        @SerializedName("time")val time: String,
        @SerializedName("url")val url: String,

        var flagImage: Int,
        var weekendDate : String,
    ) : Serializable, Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readParcelable(Circuit::class.java.classLoader)!!,
            parcel.readParcelable(FirstPractice::class.java.classLoader)!!,
            parcel.readParcelable(Qualifying::class.java.classLoader)!!,
            parcel.readParcelable(SecondPractice::class.java.classLoader)!!,
            parcel.readParcelable(com.example.f1calendarOP.ThirdPractice::class.java.classLoader)!!,
            parcel.readParcelable(Sprint::class.java.classLoader)!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readInt(),
            parcel.readString()!!
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeParcelable(circuit, flags)
            parcel.writeParcelable(firstPractice, flags)
            parcel.writeParcelable(qualifying, flags)
            parcel.writeParcelable(secondPractice, flags)
            parcel.writeParcelable(ThirdPractice, flags)
            parcel.writeParcelable(sprint, flags)
            parcel.writeString(date)
            parcel.writeString(raceName)
            parcel.writeString(round)
            parcel.writeString(season)
            parcel.writeString(time)
            parcel.writeString(url)
            parcel.writeInt(flagImage)
            parcel.writeString(weekendDate)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Race> {
            override fun createFromParcel(parcel: Parcel): Race {
                return Race(parcel)
            }

            override fun newArray(size: Int): Array<Race?> {
                return arrayOfNulls(size)
            }
        }
    }

data class Circuit(
        @SerializedName("Location")val location: Location,
        @SerializedName("circuitId")val circuitId: String,
        @SerializedName("circuitName")val circuitName: String,
        @SerializedName("url")val url: String
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Location::class.java.classLoader)!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(circuitId)
        parcel.writeString(circuitName)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Circuit> {
        override fun createFromParcel(parcel: Parcel): Circuit {
            return Circuit(parcel)
        }

        override fun newArray(size: Int): Array<Circuit?> {
            return arrayOfNulls(size)
        }
    }
}

data class FirstPractice(
        @SerializedName("date")val date: String,
        @SerializedName("time")val time: String
    ) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString()!!
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(date)
            parcel.writeString(time)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<FirstPractice> {
            override fun createFromParcel(parcel: Parcel): FirstPractice {
                return FirstPractice(parcel)
            }

            override fun newArray(size: Int): Array<FirstPractice?> {
                return arrayOfNulls(size)
            }
        }
    }

    data class Qualifying(
        @SerializedName("date")val date: String,
        @SerializedName("time")val time: String
    ) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString()!!
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(date)
            parcel.writeString(time)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Qualifying> {
            override fun createFromParcel(parcel: Parcel): Qualifying {
                return Qualifying(parcel)
            }

            override fun newArray(size: Int): Array<Qualifying?> {
                return arrayOfNulls(size)
            }
        }
    }

data class SecondPractice(
        @SerializedName("date")val date: String,
        @SerializedName("time")val time: String
    ) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString()!!
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(date)
            parcel.writeString(time)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<SecondPractice> {
            override fun createFromParcel(parcel: Parcel): SecondPractice {
                return SecondPractice(parcel)
            }

            override fun newArray(size: Int): Array<SecondPractice?> {
                return arrayOfNulls(size)
            }
        }
    }

data class ThirdPractice(
        @SerializedName("date")val date: String,
        @SerializedName("time")val time: String
    ) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString()!!
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(date)
            parcel.writeString(time)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<ThirdPractice> {
            override fun createFromParcel(parcel: Parcel): ThirdPractice {
                return ThirdPractice(parcel)
            }

            override fun newArray(size: Int): Array<ThirdPractice?> {
                return arrayOfNulls(size)
            }
        }
    }

data class Sprint(
        @SerializedName("date")val date: String,
        @SerializedName("time")val time: String
    ) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString()!!
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(date)
            parcel.writeString(time)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Sprint> {
            override fun createFromParcel(parcel: Parcel): Sprint {
                return Sprint(parcel)
            }

            override fun newArray(size: Int): Array<Sprint?> {
                return arrayOfNulls(size)
            }
        }
    }

data class Location(
        @SerializedName("country")val country: String,
        @SerializedName("lat")val lat: String,
        @SerializedName("locality")val locality: String,
        @SerializedName("long")val long: String
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(country)
        parcel.writeString(lat)
        parcel.writeString(locality)
        parcel.writeString(long)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Location> {
        override fun createFromParcel(parcel: Parcel): Location {
            return Location(parcel)
        }

        override fun newArray(size: Int): Array<Location?> {
            return arrayOfNulls(size)
        }
    }
}