package com.example.f1calendarOP

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

internal class RaceFunctions {

//        fun prepareRaceData(racesAdapter: RacesAdapter) {
//            val raceList = ArrayList<RaceF1>()
//            var race = RaceF1("18-20 MAR", "Bahrain Grand Prix", R.drawable.flag_bahrain,
//                "15:00", "18:00", "15:00",
//                "18:00","18:00", false, R.drawable.circuit_bahrain,
//                2004, 57, 5.412, "1:31.447",
//                "Pedro de la Rosa (2005)")
//            raceList.add(race)
//            race = RaceF1("25-27 MAR", "Jeddah Grand Prix", R.drawable.flag_saudi,
//                "17:00", "20:00", "17:00",
//                "20:00", "20:00", false, R.drawable.circuit_jeddah,
//                2021, 50, 6.174, "1:30.734",
//                "Lewis Hamilton (2021)")
//            raceList.add(race)
//            race = RaceF1("08-10 APR", "Melbourne Grand Prix", R.drawable.flag_australia,
//                "06:00","09:00","06:00",
//                "09:00","08:00", false, R.drawable.circuit_australia,
//                1996, 58, 5.278, "1:20.260",
//                "Lewis Hamilton (2021)")
//            raceList.add(race)
//            race = RaceF1("22-24 APR", "Imola Grand Prix", R.drawable.flag_italy,
//                "14:30", "18:00","13:30",
//                "17:30","16:00", true, R.drawable.circuit_imola,
//                1980, 63, 4.909, "1:15.484",
//                "Lewis Hamilton (2020)")
//            raceList.add(race)
//            race = RaceF1("06-08 MAY", "Miami Grand Prix", R.drawable.flag_us,
//                "21:30","00:30","20:00",
//                "23:00","22:30", false, R.drawable.circuit_miami,
//                2022, 57, 5.410, "-", "-")
//                //currently no record cause there was no any race
//            raceList.add(race)
//            race = RaceF1("20-22 MAY", "Catalunya Grand Prix", R.drawable.flag_spain,
//                "15:00","18:00","14:00",
//                "17:00","16:00", false, R.drawable.circuit_catalunya,
//                1991, 66, 4.675, "1:18.149",
//                "Max Verstappen (2021)")
//            raceList.add(race)
//            race = RaceF1("27-29 MAY", "Monaco Grand Prix", R.drawable.flag_monaco,
//                "15:00","18:00","14:00",
//                "17:00","16:00", false, R.drawable.circuit_monaco,
//                1950, 78, 3.337, "1:12.909",
//                "Lewis Hamilton (2021)")
//            raceList.add(race)
//            race = RaceF1("10-12 JUN", "Azerbaijan Grand Prix", R.drawable.flag_azerbaijan,
//                "14:00","17:00","14:00",
//                "17:00","14:00", false, R.drawable.circuit_azerbaijan,
//                2016, 51, 6.003, "1:43.009",
//                "Charles Leclerc (2019)")
//            raceList.add(race)
//            race = RaceF1("17-19 JUN", "Canadian Grand Prix", R.drawable.flag_canada,
//                "21:00", "00:00","20:00",
//                "23:00", "21:00", false, R.drawable.circuit_canada,
//                1978, 70, 4.361, "1:13.078",
//                "Valtteri Bottas (2019)")
//            raceList.add(race)
//            race = RaceF1("01-03 JUL", "Silverstone Grand Prix", R.drawable.flag_uk,
//                "15:00","18:00", "14:00",
//                "17:00", "17:00", false, R.drawable.circuit_silverstone,
//                1950, 52, 5.891, "1:27.097",
//                "Max Verstappen (2020)")
//            raceList.add(race)
//            race = RaceF1("08-10 JUL", "Red Bull Ring Grand Prix", R.drawable.flag_austria,
//                "14:30","18:00","13:30",
//                "17:30","16:00", true, R.drawable.circuit_austria,
//                1970, 71, 4.318, "1:05.619",
//                "Carlos Sainz (2020)")
//            raceList.add(race)
//            race = RaceF1("22-24 JUL", "French Grand Prix", R.drawable.flag_france,
//                "15:00", "18:00","14:00",
//                "17:00", "16:00", false, R.drawable.circuit_france,
//                1971, 53, 5.842, "1:32.740",
//                "Sebastian Vettel (2019)")
//            raceList.add(race)
//            race = RaceF1("29-31 JUL", "Hungarian Grand Prix", R.drawable.flag_hungary,
//                "15:00", "18:00", "14:00",
//                "17:00", "16:00", false, R.drawable.circuit_hungaroring,
//                1986, 70, 4.381, "1:16.627",
//                "Lewis Hamilton (2020)")
//            raceList.add(race)
//            race = RaceF1("26-28 AUG", "Spa-francorchamps Grand Prix", R.drawable.flag_belgium,
//                "15:00", "18:00","14:00",
//                "17:00", "16:00", false, R.drawable.circuit_spa,
//                1950, 44, 7.004, "1:46.286",
//                "Valtteri Bottas (2018)")
//            raceList.add(race)
//            race = RaceF1("02-04 SEP", "Zandvoort Grand Prix", R.drawable.flag_netherlands,
//                "15:00", "18:00", "14:00",
//                "17:00", "16:00", false, R.drawable.circuit_zandvoort,
//                1952, 72, 4.259, "1:11.097",
//                "Lewis Hamilton (2021)")
//            raceList.add(race)
//            race = RaceF1("09-11 SEP", "Monza Grand Prix", R.drawable.flag_italy,
//                "15:00", "18:00","14:00",
//                "17:00", "16:00", false, R.drawable.circuit_monza,
//                1950, 53, 5.793, "1:21.046",
//                "Rubens Barrichello (2004)")
//            raceList.add(race)
//            race = RaceF1("30-02 SEP-OCT", "Singapore Grand Prix", R.drawable.flag_singapore,
//                "13:00", "16:00", "13:00",
//                "16:00", "15:00",false, R.drawable.circuit_singapore,
//                2008, 61, 5.063, "1:41.905",
//                "Kevin Magnussen (2018)")
//            raceList.add(race)
//            race = RaceF1("07-09 OCT", "Suzuka Circuit Grand Prix", R.drawable.flag_japan,
//                "07:00", "10:00", "07:00",
//                "10:00", "08:00", false, R.drawable.circuit_suzuka,
//                1987, 53, 5.807, "1:30.983",
//                "Lewis Hamilton (2019)")
//            raceList.add(race)
//            race = RaceF1("21-23 OCT", "United States Grand Prix", R.drawable.flag_us,
//                "22:00", "01:00", "22:00",
//                "01:00", "22:00", false, R.drawable.circuit_usa,
//                2012, 56, 5.513, "1:36.169",
//                "Charles Leclerc (2019)")
//            raceList.add(race)
//            race = RaceF1("28-30 OCT", "Mexico Grand Prix", R.drawable.flag_mexico,
//                "21:00", "00:00", "20:00",
//                "23:00", "22:00", false, R.drawable.circuit_mexico,
//                1963, 71, 4.304, "1:17.774",
//                "Valtteri Bottas (2021)")
//            raceList.add(race)
//            race = RaceF1("11-13 NOV", "Brazil Grand Prix",  R.drawable.flag_brazil,
//                "17:30", "21:00", "17:30",
//                "21:30", "20:00",true, R.drawable.circuit_brazil,
//                1973, 71, 4.309, "1:10.540",
//            "Valtteri Bottas (2018)")
//            raceList.add(race)
//            race = RaceF1("18-20 NOV", "Abu Dhabi Grand Prix", R.drawable.flag_uae,
//                "12:00", "15:00", "13:00",
//                "16:00", "15:00", false, R.drawable.circuit_abudhabi,
//                2009, 58, 5.281, "1:26.103",
//                "Max Verstappen (2021)")
//            raceList.add(race)
//            racesAdapter.updateList(raceList)
//        }
//        fun recyclerTest() : MutableList<RaceF1Model>{
//            val raceList = mutableListOf<RaceF1Model>()
//            val race = RaceF1Model("data", "gonka", "2")
//            raceList.add(race)
//            return raceList
//        }
//        fun getRaceDetailData(race: Race): List<RaceDetailModel>{
//
//            val raceDetailList = ArrayList<RaceDetailModel>()
//            val header = RaceDetailModel.Header(
//                track = race.trackF1, date = race.dateF1, flag = race.flagImage)
//            raceDetailList.add(header)
//
//
//            val sessionTimeString = arrayListOf<String>()
//            with(sessionTimeString){
//                with(race){
//                    add(session1Time)
//                    add(session2Time)
//                    add(session3Time)
//                    add(session4Time)
//                    add(session5Time)
//                }
//            }
//            val sessionTimeStringSynced = syncTime(sessionTimeString)
//
//            val sessionDateString = getSessionDates(race.dateF1)
//
//            val session1Name = "Practice 1"
//            val session1Date : String = sessionDateString[SESSION1_INDEX]
//            val session1Time : String = sessionTimeStringSynced[SESSION1_INDEX]
//            val session1 = RaceDetailModel.Session(
//                sessionDate = session1Date, sessionName = session1Name, sessionTime = session1Time)
//            raceDetailList.add(session1)
//
//
//            var session2Name = "Practice 2"
//            var session3Name = "Practice 3"
//            var session4Name = "Qualification"
//            if(race.sprintRace){
//                session2Name = "Qualification"
//                session3Name = "Practice 2"
//                session4Name = "Sprint Race"
//            }
//            val session2Time : String = sessionTimeStringSynced[SESSION2_INDEX]
//            val session2Date : String = sessionDateString[SESSION2_INDEX]
//            val session2 = RaceDetailModel.Session(
//                sessionDate = session2Date, sessionName = session2Name, sessionTime = session2Time)
//            raceDetailList.add(session2)
//
//            val session3Date : String = sessionDateString[SESSION3_INDEX]
//            val session3Time : String = sessionTimeStringSynced[SESSION3_INDEX]
//            val session3 = RaceDetailModel.Session(
//                sessionDate = session3Date, sessionName = session3Name, sessionTime = session3Time)
//            raceDetailList.add(session3)
//
//            val session4Date : String = sessionDateString[SESSION4_INDEX]
//            val session4Time : String = sessionTimeStringSynced[SESSION4_INDEX]
//            val session4 = RaceDetailModel.Session(
//                sessionDate = session4Date, sessionName = session4Name, sessionTime = session4Time)
//            raceDetailList.add(session4)
//
//            val session5Name = "Race"
//            val session5Date : String = sessionDateString[SESSION5_INDEX]
//            val session5Time : String = sessionTimeStringSynced[SESSION5_INDEX]
//            val session5 = RaceDetailModel.Session(
//                sessionDate = session5Date, sessionName = session5Name, sessionTime = session5Time)
//            raceDetailList.add(session5)
//
//            val totalDistance : Double = ((race.circuitLaps * race.circuitLength) * 1000).roundToInt().toDouble()/1000
//
//            val circuitLayout = RaceDetailModel.Circuit(
//                circuitImage = race.circuitImage, firstYear = race.circuitFirstYear,
//                laps = race.circuitLaps, circuitLength = race.circuitLength.toString(),
//                raceDistance = totalDistance, lapRecord = race.circuitLapRecord,
//                lapRecordOwner = race.circuitLapRecordOwner)
//            raceDetailList.add(circuitLayout)
//
//            return raceDetailList
//        }

    fun getDetailApiData(race: Race) : List<RaceDetailModel>{
        val raceDetailList = ArrayList<RaceDetailModel>()
        val header = RaceDetailModel.Header(
                track = race.raceName, date = race.date, flag = R.drawable.flag_monaco)
            raceDetailList.add(header)

        val secondPractice = RaceDetailModel.Session(
            sessionDate = race.SecondPractice.date, sessionName = PRACTICE2,
            sessionTime = race.SecondPractice.time
        )
        val qualification = RaceDetailModel.Session(
            sessionDate = race.Qualifying.date, sessionName = QUALI,
            sessionTime = race.Qualifying.time
        )

        val session2 : RaceDetailModel.Session
        val session3 : RaceDetailModel.Session
        val session4 : RaceDetailModel.Session
        if(race.Sprint != null){ // If Race weekend is with Sprint Race
            session2 = qualification
            session3 = secondPractice
            session4 = RaceDetailModel.Session( // Sprint
                sessionDate = race.Sprint.date, sessionName = SPRINT,
                sessionTime = race.Sprint.time
            )
        }
        else{
            session2 = secondPractice
            session3 = RaceDetailModel.Session( // Third Practice
                sessionDate = race.ThirdPractice.date, sessionName = PRACTICE3,
                sessionTime = race.ThirdPractice.time
            )
            session4 = qualification
        }

        val session1 = RaceDetailModel.Session(
            sessionDate = race.FirstPractice.date, sessionName = PRACTICE1,
            sessionTime = race.FirstPractice.time
        )

        val session5 = RaceDetailModel.Session(
            sessionDate = race.date, sessionName = RACE,
            sessionTime = race.time
        )
        raceDetailList.apply{
            add(session1)
            add(session2)
            add(session3)
            add(session4)
            add(session5)
        }
        return raceDetailList
    }

    companion object {
        val SESSION1_INDEX = 0
        val SESSION2_INDEX = 1
        val SESSION3_INDEX = 2
        val SESSION4_INDEX = 3
        val SESSION5_INDEX = 4

        val PRACTICE1 = "Practice 1"
        val PRACTICE2 = "Practice 2"
        val PRACTICE3 = "Practice 3"
        val QUALI = "Qualifying"
        val SPRINT = "Sprint"
        val RACE = "Race"
    }


    fun getSessionDates(sourceString: String) : Array<String>{
        val fullDate = 9
        val dateString = 5
        val dateDigit = 2
        val startOfSecondDate = 3
        val singleDigit = 1
        val monthText = 3
        val dateDifference = 1
        //Session Dates
        // Extract first date and name of month from string
        var session1DateString : String
        session1DateString = sourceString.take(dateDigit) + " " + sourceString.takeLast(monthText)

        if(sourceString.length >= fullDate){   // if weekend happens in 2 different months(ex.SEP-OCT) 30-02 SEP-OCT
            session1DateString = sourceString.take(dateDigit) + " " + sourceString.substring(fullDate-monthText,fullDate)
        }
        val session2DateString : String = session1DateString

        //Setting Session 5
        val session5DateString : String = sourceString.substring(dateString-dateDigit,dateString) + " " + sourceString.takeLast(monthText)

        //Setting Session 3,4 date
        //If one date or another starts with 0
        var session3DateString : String
        session3DateString = session5DateString
        val secondDate : Char = session3DateString[startOfSecondDate]
        if(session3DateString.take(singleDigit) == "0" || secondDate.toString() == "0"){ // 30-02
            val testInt = session3DateString.substring(dateDigit-singleDigit,dateDigit).toInt() - dateDifference
            session3DateString = session3DateString.take(singleDigit) + testInt.toString() + " " + sourceString.takeLast(monthText)
        }
        else{
            session3DateString = (session3DateString.take(dateDigit).toInt() - dateDifference).toString() + " " + sourceString.takeLast(monthText)
            //if result number in date is single digit
            if(session3DateString.length == dateString){
                session3DateString = "0" + session3DateString
            }
        }
        val session4DateString : String = session3DateString
        val sessionArray = arrayOf(session1DateString, session2DateString,
        session3DateString,session4DateString, session5DateString)
        return sessionArray

    }

    fun syncTime(sessionTimeString : ArrayList<String>) : ArrayList<String>{
        val timeDigit = 2
        val myTimeZone = TimeZone.getTimeZone("Europe/Riga") // add time zone
        val currentTime = Calendar.getInstance() // add calendar library
        val simpleDateFormat = SimpleDateFormat("HH:mm") // add date format
        currentTime.timeZone = myTimeZone
        for(i in sessionTimeString.indices){
            currentTime.set(Calendar.HOUR_OF_DAY, sessionTimeString[i].take(timeDigit).toInt()) // HOUR AND MINUTES ARE INT VAR
            currentTime.set(Calendar.MINUTE,(sessionTimeString[i].takeLast(timeDigit)).toInt())
            val dateTime = simpleDateFormat.format(currentTime.time).toString() //date is displayed with selected date format and time zone
            sessionTimeString[i] = dateTime
        }
        return sessionTimeString
    }

}