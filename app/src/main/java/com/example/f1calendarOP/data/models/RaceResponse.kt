package com.example.f1calendarOP.data.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

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
@Parcelize
data class Race(
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
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Circuit::class.java.classLoader)!!,
        parcel.readParcelable(FirstPractice::class.java.classLoader)!!,
        parcel.readParcelable(Qualifying::class.java.classLoader)!!,
        parcel.readParcelable(SecondPractice::class.java.classLoader)!!,
        parcel.readParcelable(ThirdPractice::class.java.classLoader)!!,
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

    companion object : Parceler<Race> {

        override fun Race.write(parcel: Parcel, flags: Int) {
            parcel.writeParcelable(circuit, flags)
            parcel.writeParcelable(firstPractice, flags)
            parcel.writeParcelable(qualifying, flags)
            parcel.writeParcelable(secondPractice, flags)
            parcel.writeParcelable(thirdPractice, flags)
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

        override fun create(parcel: Parcel): Race {
            return Race(parcel)
        }
    }
}

@Parcelize
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

    companion object : Parceler<Circuit> {

        override fun Circuit.write(parcel: Parcel, flags: Int) {
            parcel.writeString(circuitId)
            parcel.writeString(circuitName)
            parcel.writeString(url)
        }

        override fun create(parcel: Parcel): Circuit {
            return Circuit(parcel)
        }
    }
}
@Parcelize
data class FirstPractice(
    @SerializedName("date")val date: String,
    @SerializedName("time")val time: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    )

    companion object : Parceler<FirstPractice> {

        override fun FirstPractice.write(parcel: Parcel, flags: Int) {
            parcel.writeString(date)
            parcel.writeString(time)
        }

        override fun create(parcel: Parcel): FirstPractice {
            return FirstPractice(parcel)
        }
    }
}
@Parcelize
data class Qualifying(
    @SerializedName("date")val date: String,
    @SerializedName("time")val time: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    )

    companion object : Parceler<Qualifying> {

        override fun Qualifying.write(parcel: Parcel, flags: Int) {
            parcel.writeString(date)
            parcel.writeString(time)
        }

        override fun create(parcel: Parcel): Qualifying {
            return Qualifying(parcel)
        }
    }
}

@Parcelize
data class SecondPractice(
    @SerializedName("date")val date: String,
    @SerializedName("time")val time: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    )

    companion object : Parceler<SecondPractice> {

        override fun SecondPractice.write(parcel: Parcel, flags: Int) {
            parcel.writeString(date)
            parcel.writeString(time)
        }

        override fun create(parcel: Parcel): SecondPractice {
            return SecondPractice(parcel)
        }
    }
}

@Parcelize
data class ThirdPractice(
    @SerializedName("date")val date: String,
    @SerializedName("time")val time: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    )

    companion object : Parceler<ThirdPractice> {

        override fun ThirdPractice.write(parcel: Parcel, flags: Int) {
            parcel.writeString(date)
            parcel.writeString(time)
        }

        override fun create(parcel: Parcel): ThirdPractice {
            return ThirdPractice(parcel)
        }
    }
}

@Parcelize
data class Sprint(
    @SerializedName("date")val date: String,
    @SerializedName("time")val time: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    )

    companion object : Parceler<Sprint> {

        override fun Sprint.write(parcel: Parcel, flags: Int) {
            parcel.writeString(date)
            parcel.writeString(time)
        }

        override fun create(parcel: Parcel): Sprint {
            return Sprint(parcel)
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