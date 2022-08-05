package com.example.f1calendarOP.presentation.racelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.f1calendarOP.data.network.RaceNetworkData
import com.example.f1calendarOP.data.repository.FlagRepositoryImpl
import com.example.f1calendarOP.data.repository.RaceRepositoryImpl
import com.example.f1calendarOP.domain.models.RaceModel
import com.example.f1calendarOP.domain.usecases.FormatWeekendDateUseCase
import com.example.f1calendarOP.domain.usecases.GetRaceListUseCase
import retrofit2.HttpException
import java.io.IOException

class RaceListViewModel : ViewModel() {

    private val getRaceListUseCase by lazy {
        GetRaceListUseCase(
            RaceRepositoryImpl(RaceNetworkData()),
            FlagRepositoryImpl(),
            FormatWeekendDateUseCase()
        ) }

    private val mutableRaceModelList = MutableLiveData<List<RaceModel>>()

    suspend fun getAllRaces() {

        try {
            val raceModelList = getRaceListUseCase()
            mutableRaceModelList.postValue(raceModelList)
        } catch(e: IOException) {
            println(e.message)
        } catch(e: HttpException) {
            println(e.message())
        }
    }

    fun getLiveData() : LiveData<List<RaceModel>> {
        return mutableRaceModelList
    }
}