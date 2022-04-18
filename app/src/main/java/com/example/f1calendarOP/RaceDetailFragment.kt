package com.example.f1calendarOP

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.TextView
import com.example.f1calendarOP.RaceListFragment.Companion.RACE_DATE_KEY

class RaceDetailFragment : Fragment(R.layout.fragment_race_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val race = arguments?.getSerializable(RACE_DATE_KEY) as RaceF1

        val flagDetailF1: ImageView = view.findViewById(R.id.flagDetailF1) //Flag resource
        val weekendDate : String
        val trackString : String
        with(race){
            flagDetailF1.setImageResource(flagImage)
            weekendDate = dateF1 // Date of F1(ex. 22-24 JUN)
            trackString = trackF1
        }

        val trackDetailF1: TextView = view.findViewById(R.id.trackDetailF1) // Track name
        val trackDateF1: TextView = view.findViewById(R.id.dateF1_2) // Date of GP weekend
        trackDateF1.text = weekendDate
        trackDetailF1.text = trackString

//      Session Names

        val session2Name : TextView = view.findViewById(R.id.session2Name)
        val session3Name : TextView = view.findViewById(R.id.session3Name)
        val session4Name : TextView = view.findViewById(R.id.session4Name)
        if(race.sprintRace){ // boolean
            session2Name.text = getString(R.string.session_2_sprint)
            session3Name.text = getString(R.string.session_3_sprint)
            session4Name.text = getString(R.string.session_4_sprint)
        }

        //Session Dates

        val raceFunctions = RaceFunctions()
        val sessionDateStrings = raceFunctions.getSessionDates(weekendDate)

        val session1Date : TextView = view.findViewById(R.id.session1Date)
        val session2Date : TextView = view.findViewById(R.id.session2Date)
        val session3Date : TextView = view.findViewById(R.id.session3Date)
        val session4Date : TextView = view.findViewById(R.id.session4Date)
        val session5Date : TextView = view.findViewById(R.id.session5Date)

        val sessionDateArray = arrayListOf<TextView>()
        with(sessionDateArray){
            add(session1Date)
            add(session2Date)
            add(session3Date)
            add(session4Date)
            add(session5Date)
        }

        for(i in sessionDateArray.indices){
            sessionDateArray[i].text = sessionDateStrings[i]
        }

        //Session Times

        val sessionTimeTv = arrayListOf(R.id.session1Time, R.id.session2Time, R.id.session3Time,
            R.id.session4Time, R.id.session5Time)
        val sessionTimeString = arrayListOf<String>()
        with(race){
            sessionTimeString.add(session1Time)
            sessionTimeString.add(session2Time)
            sessionTimeString.add(session3Time)
            sessionTimeString.add(session4Time)
            sessionTimeString.add(session5Time)
        }
        //sync time
        raceFunctions.syncTime(sessionTimeString, sessionTimeTv, view)
    }
}