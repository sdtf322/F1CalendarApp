package com.example.f1calendarOP

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

internal class RaceFunctions {

    fun getDetailApiData(race: Race) : ArrayList<RaceDetailModel>{
        val raceDetailList = ArrayList<RaceDetailModel>()
        val flagImage = race.flagImage

        val weekendDate = race.weekendDate
        val header = RaceDetailModel.Header(
            track = race.raceName, date = weekendDate, flag = flagImage)
        raceDetailList.add(header)

        val secondPracticeDate = formatDate(race.secondPractice.date)
        val secondPracticeTime = formatTime(race.secondPractice.time)
        val secondPractice = RaceDetailModel.Session(
            sessionDate = secondPracticeDate, sessionName = PRACTICE2,
            sessionTime = secondPracticeTime
        )

        val qualificationDate = formatDate(race.qualifying.date)
        val qualificationTime = formatTime(race.qualifying.time)
        val qualification = RaceDetailModel.Session(
            sessionDate = qualificationDate, sessionName = QUALI,
            sessionTime = qualificationTime
        )

        val session2 : RaceDetailModel.Session
        val session3 : RaceDetailModel.Session
        val session4 : RaceDetailModel.Session


        if(race.sprint != null){
            val sprintDate = formatDate(race.sprint.date)
            val sprintTime = formatTime(race.sprint.time)
            session2 = qualification
            session3 = secondPractice
            session4 = RaceDetailModel.Session( // Sprint
                sessionDate = sprintDate, sessionName = SPRINT,
                sessionTime = sprintTime
            )
        }
        else{
            session2 = secondPractice
            val thirdPracticeDate = formatDate(race.ThirdPractice.date)
            val thirdPracticeTime = formatTime(race.ThirdPractice.time)
            session3 = RaceDetailModel.Session( // Third Practice
                sessionDate = thirdPracticeDate, sessionName = PRACTICE3,
                sessionTime = thirdPracticeTime
            )
            session4 = qualification
        }


        val firstPracticeDate = formatDate(race.firstPractice.date)
        val firstPracticeTime = formatTime(race.firstPractice.time)
        val session1 = RaceDetailModel.Session(
            sessionDate = firstPracticeDate, sessionName = PRACTICE1,
            sessionTime = firstPracticeTime
        )

        val raceDate = formatDate(race.date)
        val raceTime = formatTime(race.time)
        val session5 = RaceDetailModel.Session(
            sessionDate = raceDate, sessionName = RACE,
            sessionTime = raceTime
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

    fun getWeekendDate(race : Race): String {

        val firstSessionDate = formatDate(race.firstPractice.date)
        val lastSessionDate = formatDate(race.date)

        return "$firstSessionDate - $lastSessionDate"
    }

    fun getFlagByCountry(country : String) : Int{
        val flagDrawable = when(country){ // Race Country
            "Bahrain" -> R.drawable.flag_bahrain
            "Australia" -> R.drawable.flag_australia
            "Austria" -> R.drawable.flag_austria
            "Italy" -> R.drawable.flag_italy
            "USA" -> R.drawable.flag_us
            "Spain" -> R.drawable.flag_spain
            "Monaco" -> R.drawable.flag_monaco
            "Azerbaijan" -> R.drawable.flag_azerbaijan
            "Canada" -> R.drawable.flag_canada
            "UK" -> R.drawable.flag_uk
            "France" -> R.drawable.flag_france
            "Hungary" -> R.drawable.flag_hungary
            "Belgium" -> R.drawable.flag_belgium
            "Netherlands" -> R.drawable.flag_netherlands
            "Singapore" -> R.drawable.flag_singapore
            "Japan" -> R.drawable.flag_japan
            "Mexico" -> R.drawable.flag_mexico
            "Brazil" -> R.drawable.flag_brazil
            "UAE" -> R.drawable.flag_uae
            "Saudi Arabia" -> R.drawable.flag_saudi

            else -> R.drawable.flag_unknown
        }
        return flagDrawable
    }

    fun formatDate(raceDate: String): String {

        val inputFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        val outputFormatter = SimpleDateFormat("dd-MMMM", Locale.ENGLISH)
        val givenDate = inputFormatter.parse(raceDate)

        return outputFormatter.format(givenDate)

    }
    fun formatTime(raceTime: String): String {

        val timeInputFormatter = SimpleDateFormat("HH:mm:ss'Z'", Locale.ENGLISH)
        val timeOutputFormatter = SimpleDateFormat("HH:mm", Locale.ENGLISH)
        val parsedTime = timeInputFormatter.parse(raceTime)

        return timeOutputFormatter.format(parsedTime)

    }

//    fun syncTime(sessionTimeString : ArrayList<String>) : ArrayList<String>{
//        val timeDigit = 2
//        val myTimeZone = TimeZone.getTimeZone("Europe/Riga") // add time zone
//        val currentTime = Calendar.getInstance() // add calendar library
//        val simpleDateFormat = SimpleDateFormat("HH:mm") // add date format
//        currentTime.timeZone = myTimeZone
//        for(i in sessionTimeString.indices){
//            currentTime.set(Calendar.HOUR_OF_DAY, sessionTimeString[i].take(timeDigit).toInt()) // HOUR AND MINUTES ARE INT VAR
//            currentTime.set(Calendar.MINUTE,(sessionTimeString[i].takeLast(timeDigit)).toInt())
//            val dateTime = simpleDateFormat.format(currentTime.time).toString() //date is displayed with selected date format and time zone
//            sessionTimeString[i] = dateTime
//        }
//        return sessionTimeString
//    }
    companion object {
        val PRACTICE1 = "Practice 1"
        val PRACTICE2 = "Practice 2"
        val PRACTICE3 = "Practice 3"
        val QUALI = "Qualifying"
        val SPRINT = "Sprint"
        val RACE = "Race"
    }
}