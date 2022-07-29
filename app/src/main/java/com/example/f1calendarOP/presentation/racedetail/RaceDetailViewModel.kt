package com.example.f1calendarOP.presentation.racedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.f1calendarOP.data.RaceFunctions
import com.example.f1calendarOP.domain.models.RaceModel
import com.example.f1calendarOP.domain.models.RaceDetailModel

class RaceDetailViewModel(private val raceModel : RaceModel) : ViewModel() {

    private val raceInfoMutable = MutableLiveData<ArrayList<RaceDetailModel>>()

    fun getDetailInfo() {
        val raceFunctions = RaceFunctions()
        val raceDetailModels = raceFunctions.getDetailApiData(raceModel)
        raceInfoMutable.value = raceDetailModels
    }
    fun getLiveData() : LiveData<ArrayList<RaceDetailModel>> {
        return raceInfoMutable
    }

}