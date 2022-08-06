package com.example.f1calendarOP.presentation.racelist

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.f1calendarOP.*
import com.example.f1calendarOP.domain.models.RaceModel
import kotlinx.coroutines.runBlocking

const val TAG = "RaceListFragment"

class RaceListFragment : Fragment(R.layout.fragment_race_list) {
    private lateinit var raceListViewModel: RaceListViewModel
    private val raceListAdapter: RaceListAdapter by lazy {
        RaceListAdapter { race -> onClickHelper(race) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val listItems: View = inflater.inflate(R.layout.fragment_race_list, container, false)
        val recyclerView = listItems.findViewById<View>(R.id.recyclerView) as RecyclerView
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            itemAnimator = DefaultItemAnimator()
            adapter = raceListAdapter
        }
        return listItems
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        raceListViewModel = ViewModelProvider(
            this)[RaceListViewModel::class.java]

        raceListViewModel.getLiveData().observe(viewLifecycleOwner) {
            raceListAdapter.submitList(it)
        }
        runBlocking {
            raceListViewModel.getAllRaces()
        }
    }

    private fun onClickHelper(raceModel: RaceModel) {
        val action = RaceListFragmentDirections.actionRaceListFragmentToRaceDetailFragment(raceModel)
        findNavController().navigate(action)
    }
}