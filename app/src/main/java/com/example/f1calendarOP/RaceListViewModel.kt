package com.example.f1calendarOP

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RaceListViewModel : ViewModel() {

    val raceList = MutableLiveData<List<Race>>()

    fun getAllRaces() {
        viewModelScope.launch {
            val response = RetrofitInstance.api.getRaceInfo()
            //currently here is no checking if connection to api is failed etc.

            if (response != null) {
                val responseRaceList: List<Race> = response.mrData.raceTable.races
                val raceFunctions = RaceFunctions()
                for (item in responseRaceList) {
                    item.flagImage = raceFunctions.getFlagByCountry(item.circuit.location.country)
                    item.weekendDate = raceFunctions.getWeekendDate(item)
                }
                raceList.postValue(responseRaceList)
            } else {
                Log.e(TAG, "Response not successful")
            }
        }
    }
}