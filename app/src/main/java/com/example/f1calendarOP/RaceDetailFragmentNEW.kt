package com.example.f1calendarOP

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RaceDetailFragmentNEW : Fragment(R.layout.fragment_race_detail2) {

    private val raceDetailAdapter : RaceDetailAdapter by lazy {RaceDetailAdapter()}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView : RecyclerView = view.findViewById(R.id.recyclerViewDetail) // init
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            itemAnimator = DefaultItemAnimator()
            adapter = raceDetailAdapter
        }

        val raceFunctions = RaceFunctions()
        val race = arguments?.getSerializable(RaceListFragment.RACE_DATE_KEY) as RaceF1
        raceDetailAdapter.updateList(raceFunctions.getRaceDetailData(race))
    }
}