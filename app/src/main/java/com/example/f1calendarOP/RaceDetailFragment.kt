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
        flagDetailF1.setImageResource(race.flagImage)

        val trackDetailF1: TextView = view.findViewById(R.id.trackDetailF1) // Track name
        val trackDateF1: TextView = view.findViewById(R.id.dateF1_2) // Date of GP weekend
        val weekendDate : String = race.dateF1 // Date of F1(ex. 22-24 JUN)
        val trackString : String = race.trackF1
        trackDateF1.text = weekendDate
        trackDetailF1.text = trackString


        //Session Names
        data class SessionNames(var session2Name : TextView,
        var session3Name: TextView, var session4Name: TextView)

        var sessionNames = SessionNames(session2Name = view.findViewById(R.id.session2Name),
            session3Name = view.findViewById(R.id.session3Name),
            session4Name = view.findViewById(R.id.session4Name))

        if(race.sprintRace){ // boolean
            with(sessionNames){
                session2Name.text = getString(R.string.session_2_sprint)
                session3Name.text = getString(R.string.session_3_sprint)
                session4Name.text = getString(R.string.session_4_sprint)
            }
        }


        //Session Dates
        data class SessionDates(var session1Date : TextView, var session2Date : TextView,
        var session3Date : TextView, var session4Date : TextView, var session5Date : TextView)

        var sessionDates = SessionDates(session1Date = view.findViewById(R.id.session1Date),
        session2Date = view.findViewById(R.id.session2Date), session3Date = view.findViewById(R.id.session3Date),
        session4Date = view.findViewById(R.id.session4Date), session5Date = view.findViewById(R.id.session5Date))

        val raceFunctions = RaceFunctions()
        val sessionDateStrings = raceFunctions.getSessionDates(weekendDate)

        val abobaList : ArrayList<TextView> = ArrayList()
        with(abobaList){
            add(sessionDates.session1Date)
            add(sessionDates.session2Date)
            add(sessionDates.session3Date)
            add(sessionDates.session4Date)
            add(sessionDates.session5Date)
        }
        for(i in abobaList.indices){
            abobaList[i].text = sessionDateStrings[i]
        }



        //Session Times
        val sessionTimeTv = arrayOf(R.id.session1Time, R.id.session2Time, R.id.session3Time,
            R.id.session4Time, R.id.session5Time)
        val sessionTimeString = arrayOf(race.session1Time,
            race.session2Time, race.session3Time,
            race.session4Time, race.session5Time)
        //sync time
        with(raceFunctions) {
            syncTime(sessionTimeString, sessionTimeTv, view)
        }
    }
}