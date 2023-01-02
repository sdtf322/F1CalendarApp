package com.example.f1calendarOP.presentation.racedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.f1calendarOP.domain.models.RaceModel
import com.example.f1calendarOP.domain.models.RaceDetailModel
import com.example.f1calendarOP.domain.usecases.GetRaceDetailByIdUseCase

class RaceDetailViewModel(
    private val raceModel: RaceModel,
    private val getRaceDetailByIdUseCase: GetRaceDetailByIdUseCase
) : ViewModel() {

    private val raceInfoMutable = MutableLiveData<ArrayList<RaceDetailModel>>()

    fun getDetailInfo() {
        val raceDetailModels = getRaceDetailByIdUseCase(raceModel)
        raceInfoMutable.value = raceDetailModels
    }

    fun getLiveData(): LiveData<ArrayList<RaceDetailModel>> {
        return raceInfoMutable
    }

}