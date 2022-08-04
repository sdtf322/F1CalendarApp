package com.example.f1calendarOP.presentation.racelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.f1calendarOP.data.network.RaceNetworkStorage
import com.example.f1calendarOP.data.repository.RaceRepositoryImpl
import com.example.f1calendarOP.domain.models.RaceModel
import com.example.f1calendarOP.domain.usecases.GetRaceListUseCase

    private val raceNetworkStorage by lazy { RaceNetworkStorage() }
    private val raceRepository by lazy { RaceRepositoryImpl(raceNetworkStorage) }
    private val getRaceList by lazy { GetRaceListUseCase(raceRepository) }

class RaceListViewModel : ViewModel() {

    private val mutableRaceModelList = MutableLiveData<List<RaceModel>>()

    fun getAllRaces() {
        val raceModelList = getRaceList.execute()
        mutableRaceModelList.postValue(raceModelList)
    }

    fun getLiveData() : LiveData<List<RaceModel>> {
        return mutableRaceModelList
    }
}