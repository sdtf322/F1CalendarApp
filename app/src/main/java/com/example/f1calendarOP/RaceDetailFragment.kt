package com.example.f1calendarOP

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.TextView
import com.example.f1calendarOP.RaceListFragment.Companion.RACE_DATE_KEY
import java.text.SimpleDateFormat
import java.util.*

class RaceDetailFragment : Fragment(R.layout.fragment_race_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val race = arguments?.getSerializable(RACE_DATE_KEY) as RaceF1
        //binding variables to textviews
        val trackDetailF1: TextView = view.findViewById(R.id.trackDetailF1) // Track name
        val trackDateF1: TextView = view.findViewById(R.id.dateF1_2) // Date of GP weekend
        val flagDetailF1: ImageView = view.findViewById(R.id.flagDetailF1) //Flag resource
        val session1Date : TextView = view.findViewById(R.id.session1Date)
        val session2Date : TextView = view.findViewById(R.id.session2Date)
        val session3Date : TextView = view.findViewById(R.id.session3Date)
        val session4Date : TextView = view.findViewById(R.id.session4Date)
        val session5Date : TextView = view.findViewById(R.id.session5Date)
        val sessionTimeTv = arrayOf(R.id.session1Time, R.id.session2Time, R.id.session3Time,
            R.id.session4Time, R.id.session5Time)
        val session2 : TextView = view.findViewById(R.id.session2) // Practice 2 / Sprint Quali
        val session3 : TextView = view.findViewById(R.id.session3) // Practice 3 / Practice 2
        val session4 : TextView = view.findViewById(R.id.session4) // Quali / Sprint Race
        //Intent
        val weekendDate : String = race.dateF1 // Date of F1(ex. 22-24 JUN)
        val trackString : String = race.trackF1
        val sessionTimeString = arrayOf(race.session1Time,
            race.session2Time, race.session3Time,
            race.session4Time, race.session5Time)
        flagDetailF1.setImageResource(race.flagImage)

        // SPRINT RACES check, in this 3 races session names differs
        if(trackString == "Imola Grand Prix" || trackString == "Red Bull Ring Grand Prix" || trackString == "Brazil Grand Prix"){
            session2.text = getString(R.string.session_2_sprint)
            session3.text = getString(R.string.session_3_sprint)
            session4.text = getString(R.string.session_4_sprint)
        }

        //Binding information to existing textviews
        trackDateF1.text = weekendDate
        trackDetailF1.text = trackString

        var session1DateString : String
        var session3DateString : String
        var session5DateString : String

        val fullDate = 9
        val dateString = 5
        val dateDigit = 2
        val startOfSecondDate = 3
        val singleDigit = 1
        val monthText = 3
        val dateDifference = 1


        //Setting Session 1,2 date
        // Extract first date and name of month from string
        session1DateString = weekendDate.take(dateDigit) + " " + weekendDate.takeLast(monthText)
        // Case when weekend happens in 2 different months(ex.SEP-OCT) 30-02 SEP-OCT
        if(weekendDate.length >= fullDate){
           session1DateString = weekendDate.take(dateDigit) + " " + weekendDate.substring(fullDate-monthText,fullDate)
        }
        var session2DateString : String = session1DateString

        session1Date.text = session1DateString
        session2Date.text = session2DateString

        //Setting Session 5
        session5DateString = weekendDate.substring(dateString-dateDigit,dateString) + " " + weekendDate.takeLast(monthText)
        session5Date.text = session5DateString


        //Setting Session 3,4 date
        //If one date or another starts with 0
        session3DateString = session5DateString
        val secondDate : Char = session3DateString[startOfSecondDate]
        if(session3DateString.take(singleDigit) == "0" || secondDate.toString() == "0"){ // 30-02
            val testInt = session3DateString.substring(dateDigit-singleDigit,dateDigit).toInt() - dateDifference
            session3DateString = session3DateString.take(singleDigit) + testInt.toString() + " " + weekendDate.takeLast(monthText)
        }
       else{
            session3DateString = (session3DateString.take(dateDigit).toInt() - dateDifference).toString() + " " + weekendDate.takeLast(monthText)
            //if result number in date is single digitgv
            if(session3DateString.length == dateString){
                session3DateString = "0" + session3DateString
            }
        }
        var session4DateString : String = session3DateString

        session3Date.text = session3DateString
        session4Date.text = session4DateString
        //------------------------------------------------------------------------------------------------------------
        // Sync with user local time

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