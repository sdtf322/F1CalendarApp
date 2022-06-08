package com.example.f1calendarOP

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.HttpException
import java.io.IOException

const val TAG = "RaceListFragment"

class RaceListFragment : Fragment(R.layout.fragment_race_list) {

    private lateinit var raceListAdapter: RaceListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        raceListAdapter = RaceListAdapter{position -> onClickHelper(position)}
        val listItems : View = inflater.inflate(R.layout.fragment_race_list, container, false)
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

        lifecycleScope.launchWhenCreated {
            val response = try {
                RetrofitInstance.api.getRaceInfo()
            } catch (e: IOException){
                Log.e(TAG, e.message.toString())
                return@launchWhenCreated
            } catch(e: HttpException){
                Log.e(TAG, e.message.toString())
                return@launchWhenCreated
            }
            if(response != null){
                val responseRaceList : List<Race> = response.mrData.raceTable.races
                val raceFunctions = RaceFunctions()
                for(item in responseRaceList){
                    item.flagImage = raceFunctions.getFlagByCountry(item.circuit.location.country)
                    item.weekendDate = raceFunctions.getWeekendDate(item)
                }
            raceListAdapter.raceList = responseRaceList

            } else{
                Log.e(TAG, "Response not successful")
            }
        }
    }


    fun onClickHelper(position: Int){
        Toast.makeText(context, "aboba ${position}", Toast.LENGTH_LONG).show()
//        val raceDetailFragment = RaceDetailFragment()
//        val bundle = Bundle()
//        bundle.putSerializable(RACE_DATE_KEY, race)
//        raceDetailFragment.arguments = bundle
//        val fragmentTransaction = parentFragmentManager.beginTransaction()
//        fragmentTransaction.apply {
//            add(R.id.flFragment, raceDetailFragment)
//            addToBackStack(null)
//            commit()
        }
        companion object{
            const val RACE_DATE_KEY = "RACETRACK"
        }
    }
//    fun onClickHelper(race: Race){
//        val raceDetailFragment = RaceDetailFragment()
//        val bundle = Bundle()
//        bundle.putSerializable(RACE_DATE_KEY, race)
//        raceDetailFragment.arguments = bundle
//        val fragmentTransaction = parentFragmentManager.beginTransaction()
//        fragmentTransaction.apply {
//            add(R.id.flFragment, raceDetailFragment)
//            addToBackStack(null)
//            commit()
//        }
//    }