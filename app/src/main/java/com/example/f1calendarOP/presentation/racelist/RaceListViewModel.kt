package com.example.f1calendarOP.presentation.racelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.f1calendarOP.data.network.RaceNetworkData
import com.example.f1calendarOP.data.repository.RaceRepositoryImpl
import com.example.f1calendarOP.domain.models.RaceModel
import com.example.f1calendarOP.domain.usecases.GetRaceListUseCase

    private val raceNetworkData by lazy { RaceNetworkData() }
    private val raceRepository by lazy { RaceRepositoryImpl(raceNetworkData) }
    private val getRaceListUseCase by lazy { GetRaceListUseCase(raceRepository) }

class RaceListViewModel : ViewModel() {

    private val mutableRaceModelList = MutableLiveData<List<RaceModel>>()

    suspend fun getAllRaces() {
        val raceModelList = getRaceListUseCase()
        mutableRaceModelList.postValue(raceModelList)
    }

    fun getLiveData() : LiveData<List<RaceModel>> {
        return mutableRaceModelList
    }
}