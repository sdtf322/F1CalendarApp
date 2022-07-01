package com.example.f1calendarOP

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

const val TAG = "RaceListFragment"

class RaceListFragment : Fragment(R.layout.fragment_race_list) {

    private lateinit var viewModel: RaceListViewModel
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

//        lifecycleScope.launchWhenCreated {
//            val response = try {
//                RetrofitInstance.api.getRaceInfo()
//            } catch (e: IOException) {
//                Log.e(TAG, e.message.toString())
//                return@launchWhenCreated
//            } catch (e: HttpException) {
//                Log.e(TAG, e.message.toString())
//                return@launchWhenCreated
//            }
//            if (response != null) {
//                val responseRaceList: List<Race> = response.mrData.raceTable.races
//                val raceFunctions = RaceFunctions()
//                for (item in responseRaceList) {
//                    item.flagImage = raceFunctions.getFlagByCountry(item.circuit.location.country)
//                    item.weekendDate = raceFunctions.getWeekendDate(item)
//                }
//                raceListAdapter.submitList(responseRaceList)
//            } else {
//                Log.e(TAG, "Response not successful")
//            }
//        }

        viewModel = ViewModelProvider(
            this,
            RaceListViewModelFactory())[RaceListViewModel::class.java]

        viewModel.raceList.observe(viewLifecycleOwner) {
            raceListAdapter.submitList(it)
        }
        viewModel.getAllRaces()
    }

    private fun onClickHelper(race: Race) {

        val action = RaceListFragmentDirections.actionRaceListFragmentToRaceDetailFragment(race)
        findNavController().navigate(action)
    }
}