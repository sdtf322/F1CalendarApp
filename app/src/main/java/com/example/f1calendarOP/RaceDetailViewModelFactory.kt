package com.example.f1calendarOP

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.f1calendarOP.domain.models.Race
import java.lang.IllegalArgumentException

class RaceDetailViewModelFactory(private val raceModel : Race) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RaceDetailViewModel::class.java)){
            return RaceDetailViewModel(raceModel) as T
        }
        else{
            throw IllegalArgumentException("Unknown View Model")
        }
    }
}
