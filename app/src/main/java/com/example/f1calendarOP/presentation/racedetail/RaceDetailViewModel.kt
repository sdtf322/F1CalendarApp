package com.example.f1calendarOP.presentation.racedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.f1calendarOP.data.repository.CircuitRepositoryImpl
import com.example.f1calendarOP.domain.models.RaceModel
import com.example.f1calendarOP.domain.models.RaceDetailModel
import com.example.f1calendarOP.domain.usecases.FormatWeekendDateUseCase
import com.example.f1calendarOP.domain.usecases.FormatWeekendTimeUseCase
import com.example.f1calendarOP.domain.usecases.GetRaceDetailByIdUseCase

class RaceDetailViewModel(private val raceModel : RaceModel) : ViewModel() {

    private val raceInfoMutable = MutableLiveData<ArrayList<RaceDetailModel>>()

    private val getRaceDetailByIdUseCase by lazy {
        GetRaceDetailByIdUseCase(
            formatWeekendDateUseCase,
            formatWeekendTimeUseCase,
            circuitRepository
        )
    }

    private val circuitRepository by lazy {
        CircuitRepositoryImpl()
    }

    private val formatWeekendDateUseCase by lazy {
        FormatWeekendDateUseCase()
    }

    private val formatWeekendTimeUseCase by lazy {
        FormatWeekendTimeUseCase()
    }

    fun getDetailInfo() {
        val raceDetailModels = getRaceDetailByIdUseCase(raceModel)
        raceInfoMutable.value = raceDetailModels
    }
    fun getLiveData() : LiveData<ArrayList<RaceDetailModel>> {
        return raceInfoMutable
    }

}