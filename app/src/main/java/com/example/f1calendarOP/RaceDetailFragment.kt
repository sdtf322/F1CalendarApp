package com.example.f1calendarOP

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RaceDetailFragment : Fragment(R.layout.fragment_race_detail) {

    companion object {
        private const val RACE_DATE_KEY = "RACETRACK"

        fun newInstance(race: Race) = RaceDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(RACE_DATE_KEY, race)
            }
        }
    }

    private val raceDetailAdapter : RaceDetailAdapter by lazy { RaceDetailAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val listItems : View = inflater.inflate(R.layout.fragment_race_detail, container, false)
        val recyclerView = listItems.findViewById<View>(R.id.recyclerViewDetail) as RecyclerView
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            itemAnimator = DefaultItemAnimator()
            adapter = raceDetailAdapter
        }
        return listItems
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val race = arguments?.getSerializable(RACE_DATE_KEY) as Race
        val raceFunctions = RaceFunctions()

        raceDetailAdapter.setRaceDetailList(raceFunctions.getDetailApiData(race))
    }
}