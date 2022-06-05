package com.example.f1calendarOP

import android.widget.ImageView
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

internal class RaceFunctions {

    fun getDetailApiData(race: Race) : List<RaceDetailModel>{
        val raceDetailList = ArrayList<RaceDetailModel>()
        val raceCountry = race.Circuit.Location.country
        val flagImage = getFlagByCountry(raceCountry)


        val weekendDate = getWeekendDate(race)
        val header = RaceDetailModel.Header(
            track = race.raceName, date = weekendDate, flag = flagImage)
        raceDetailList.add(header)

        val secondPracticeDate = formatDate(race.SecondPractice.date)
        val secondPracticeTime = formatTime(race.SecondPractice.time)
        val secondPractice = RaceDetailModel.Session(
            sessionDate = secondPracticeDate, sessionName = PRACTICE2,
            sessionTime = secondPracticeTime
        )

        val qualificationDate = formatDate(race.Qualifying.date)
        val qualificationTime = formatTime(race.Qualifying.time)
        val qualification = RaceDetailModel.Session(
            sessionDate = qualificationDate, sessionName = QUALI,
            sessionTime = qualificationTime
        )

        val session2 : RaceDetailModel.Session
        val session3 : RaceDetailModel.Session
        val session4 : RaceDetailModel.Session


        if(race.Sprint != null){
            val sprintDate = formatDate(race.Sprint.date)
            val sprintTime = formatTime(race.Sprint.time)
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


        val firstPracticeDate = formatDate(race.FirstPractice.date)
        val firstPracticeTime = formatTime(race.FirstPractice.time)
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

        val firstSessionDate = formatDate(race.FirstPractice.date)
        val lastSessionDate = formatDate(race.date)

        return "$firstSessionDate - $lastSessionDate"
    }

    fun BindFlagByCountry(country : String, flagImage : ImageView){
        val flagByCountry = getFlagByCountry(country)
        flagImage.setImageResource(flagByCountry)
    }

    fun getFlagByCountry(country : String) : Int{
        var flagDrawable = R.drawable.flag_austria
        when(country){ // Race Country
            "Bahrain" -> flagDrawable = R.drawable.flag_bahrain
            "Australia" -> flagDrawable = R.drawable.flag_australia
            "Austria" -> flagDrawable = R.drawable.flag_austria
            "Italy" -> flagDrawable = R.drawable.flag_italy
            "USA" -> flagDrawable = R.drawable.flag_us
            "Spain" -> flagDrawable = R.drawable.flag_spain
            "Monaco" -> flagDrawable = R.drawable.flag_monaco
            "Azerbaijan" -> flagDrawable = R.drawable.flag_azerbaijan
            "Canada" -> flagDrawable = R.drawable.flag_canada
            "UK" -> flagDrawable = R.drawable.flag_uk
            "France" -> flagDrawable = R.drawable.flag_france
            "Hungary" -> flagDrawable = R.drawable.flag_hungary
            "Belgium" -> flagDrawable = R.drawable.flag_belgium
            "Netherlands" -> flagDrawable = R.drawable.flag_netherlands
            "Singapore" -> flagDrawable = R.drawable.flag_singapore
            "Japan" -> flagDrawable = R.drawable.flag_japan
            "Mexico" -> flagDrawable = R.drawable.flag_mexico
            "Brazil" -> flagDrawable = R.drawable.flag_brazil
            "UAE" -> flagDrawable = R.drawable.flag_uae
            "Saudi Arabia" -> flagDrawable = R.drawable.flag_saudi
        }
        return flagDrawable
    }

    fun formatDate(raceDate : String) : String{
        val dateInputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val dateOutputFormatter = DateTimeFormatter.ofPattern("dd-MMMM")
        val parsedDate = LocalDate.parse(raceDate, dateInputFormatter)
        val formattedDate = dateOutputFormatter.format(parsedDate)

        return formattedDate
    }
    fun formatTime(raceTime : String) : String{
        val timeInputFormatter = DateTimeFormatter.ofPattern("HH:mm:ss'Z'")
        val timeOutputFormatter = DateTimeFormatter.ofPattern("HH:mm")
        val parsedTime = LocalTime.parse(raceTime, timeInputFormatter)
        val formattedTime = timeOutputFormatter.format(parsedTime)

        return formattedTime

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