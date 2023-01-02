package com.example.f1calendarOP.di

import com.example.f1calendarOP.domain.usecases.GetRaceListUseCase
import com.example.f1calendarOP.presentation.racelist.RaceListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideRaceListViewModelFactory(
        getRaceListUseCase: GetRaceListUseCase
    ): RaceListViewModelFactory {
        return RaceListViewModelFactory(getRaceListUseCase = getRaceListUseCase)
    }
}