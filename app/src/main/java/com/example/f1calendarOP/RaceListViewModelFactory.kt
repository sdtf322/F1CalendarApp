package com.example.f1calendarOP

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class RaceListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RaceListViewModel::class.java)){
            return RaceListViewModel() as T
        }
        else{
            throw IllegalArgumentException("Unknown View Model")
        }
    }
}