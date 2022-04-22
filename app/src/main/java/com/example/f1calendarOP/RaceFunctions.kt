package com.example.f1calendarOP

import android.view.View
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

internal class RaceFunctions() {

        fun prepareRaceData(raceList : ArrayList<RaceF1>, racesAdapter: RacesAdapter) : ArrayList<RaceF1> {
            var race = RaceF1("18-20 MAR", "Bahrain Grand Prix", R.drawable.flag_bahrain,
                "15:00", "18:00", "15:00",
                "18:00","18:00", false)
            raceList.add(race)
            race = RaceF1("25-27 MAR", "Jeddah Grand Prix", R.drawable.flag_saudi,
                "17:00", "20:00", "17:00",
                "20:00", "20:00", false)
            raceList.add(race)
            race = RaceF1("08-10 APR", "Melbourne Grand Prix", R.drawable.flag_australia,
                "06:00","09:00","06:00",
                "09:00","08:00", false)
            raceList.add(race)
            race = RaceF1("22-24 APR", "Imola Grand Prix", R.drawable.flag_italy,
                "14:30", "18:00","13:30",
                "17:30","16:00", true)
            raceList.add(race)
            race = RaceF1("06-08 MAY", "Miami Grand Prix", R.drawable.flag_us,
                "21:30","00:30","20:00",
                "23:00","22:30", false)
            raceList.add(race)
            race = RaceF1("20-22 MAY", "Catalunya Grand Prix", R.drawable.flag_spain,
                "15:00","18:00","14:00",
                "17:00","16:00", false)
            raceList.add(race)
            race = RaceF1("27-29 MAY", "Monaco Grand Prix", R.drawable.flag_monaco,
                "15:00","18:00","14:00",
                "17:00","16:00", false)
            raceList.add(race)
            race = RaceF1("10-12 JUN", "Azerbaijan Grand Prix", R.drawable.flag_azerbaijan,
                "14:00","17:00","14:00",
                "17:00","14:00", false)
            raceList.add(race)
            race = RaceF1("17-19 JUN", "Canadian Grand Prix", R.drawable.flag_canada,
                "21:00", "00:00","20:00",
                "23:00", "21:00", false)
            raceList.add(race)
            race = RaceF1("01-03 JUL", "Silverstone Grand Prix", R.drawable.flag_uk,
                "15:00","18:00", "14:00",
                "17:00", "17:00", false)
            raceList.add(race)
            race = RaceF1("08-10 JUL", "Red Bull Ring Grand Prix", R.drawable.flag_austria,
                "14:30","18:00","13:30",
                "17:30","16:00", true)
            raceList.add(race)
            race = RaceF1("22-24 JUL", "French Grand Prix", R.drawable.flag_france,
                "15:00", "18:00","14:00",
                "17:00", "16:00", false)
            raceList.add(race)
            race = RaceF1("29-31 JUL", "Hungarian Grand Prix", R.drawable.flag_hungary,
                "15:00", "18:00", "14:00",
                "17:00", "16:00", false)
            raceList.add(race)
            race = RaceF1("26-28 AUG", "Spa-francorchamps Grand Prix", R.drawable.flag_belgium,
                "15:00", "18:00","14:00",
                "17:00", "16:00", false)
            raceList.add(race)
            race = RaceF1("02-04 SEP", "Zandvoort Grand Prix", R.drawable.flag_netherlands,
                "15:00", "18:00", "14:00",
                "17:00", "16:00", false)
            raceList.add(race)
            race = RaceF1("09-11 SEP", "Monza Grand Prix", R.drawable.flag_italy,
                "15:00", "18:00","14:00",
                "17:00", "16:00", false)
            raceList.add(race)
            race = RaceF1("30-02 SEP-OCT", "Singapore Grand Prix", R.drawable.flag_singapore,
                "13:00", "16:00", "13:00",
                "16:00", "15:00",false)
            raceList.add(race)
            race = RaceF1("07-09 OCT", "Suzuka Circuit Grand Prix", R.drawable.flag_japan,
                "07:00", "10:00", "07:00",
                "10:00", "08:00", false)
            raceList.add(race)
            race = RaceF1("21-23 OCT", "United States Grand Prix", R.drawable.flag_us,
                "22:00", "01:00", "22:00",
                "01:00", "22:00", false)
            raceList.add(race)
            race = RaceF1("28-30 OCT", "Mexico Grand Prix", R.drawable.flag_mexico,
                "21:00", "00:00", "20:00",
                "23:00", "22:00", false)
            raceList.add(race)
            race = RaceF1("11-13 NOV", "Brazil Grand Prix",  R.drawable.flag_brazil,
                "17:30", "21:00", "17:30",
                "21:30", "20:00",true)
            raceList.add(race)
            race = RaceF1("18-20 NOV", "Abu Dhabi Grand Prix", R.drawable.flag_uae,
                "12:00", "15:00", "13:00",
                "16:00", "15:00", false)
            raceList.add(race)
            racesAdapter.updateList(raceList)
            return raceList
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
        var session2DateString : String = session1DateString

        //Setting Session 5
        var session5DateString : String
        session5DateString = sourceString.substring(dateString-dateDigit,dateString) + " " + sourceString.takeLast(monthText)

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
        var session4DateString : String = session3DateString
        val sessionArray = arrayOf(session1DateString, session2DateString,
        session3DateString,session4DateString, session5DateString)
        return sessionArray

    }
    fun syncTime(sessionTimeString : ArrayList<String>, sessionTimeTv : ArrayList<Int>, view:View){
        val timeDigit = 2
        val myTimeZone = TimeZone.getTimeZone("Europe/Riga") // add tim ezone
        val currentTime = Calendar.getInstance() // add calendar library
        val simpleDateFormat = SimpleDateFormat("HH:mm") // add date format
        currentTime.timeZone = myTimeZone
        for(i in sessionTimeString.indices){
            currentTime.set(Calendar.HOUR_OF_DAY, sessionTimeString[i].take(timeDigit).toInt()) // HOUR AND MINUTES ARE INT VAR
            currentTime.set(Calendar.MINUTE,(sessionTimeString[i].takeLast(timeDigit)).toInt())
            val dateTime = simpleDateFormat.format(currentTime.time).toString() //date is displayed with selected date format and time zone
            view.findViewById<TextView>(sessionTimeTv[i]).setText(dateTime)
        }
    }


}