package com.example.f1calendarOP.presentation.racedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.f1calendarOP.domain.models.RaceModel
import java.lang.IllegalArgumentException

class RaceDetailViewModelFactory(private val raceModel : RaceModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RaceDetailViewModel::class.java)){
            return RaceDetailViewModel(raceModel) as T
        }
        else{
            throw IllegalArgumentException("Unknown View Model")
        }
    }
}
