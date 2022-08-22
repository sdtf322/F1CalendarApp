package com.example.f1calendarOP.presentation.racelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.f1calendarOP.domain.usecases.GetRaceListUseCase

class RaceListViewModelFactory(
    private val getRaceListUseCase: GetRaceListUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RaceListViewModel(
            getRaceListUseCase = getRaceListUseCase
        ) as T
    }
}