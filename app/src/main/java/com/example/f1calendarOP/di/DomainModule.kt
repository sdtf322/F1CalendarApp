package com.example.f1calendarOP.di

import com.example.f1calendarOP.domain.repository.CircuitRepository
import com.example.f1calendarOP.domain.repository.FlagRepository
import com.example.f1calendarOP.domain.repository.RaceRepository
import com.example.f1calendarOP.domain.usecases.FormatWeekendDateUseCase
import com.example.f1calendarOP.domain.usecases.FormatWeekendTimeUseCase
import com.example.f1calendarOP.domain.usecases.GetRaceDetailByIdUseCase
import com.example.f1calendarOP.domain.usecases.GetRaceListUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideFormatWeekendDateUseCase(): FormatWeekendDateUseCase {
        return FormatWeekendDateUseCase()
    }

    @Provides
    fun provideFormatWeekendTimeUseCase(): FormatWeekendTimeUseCase {
        return FormatWeekendTimeUseCase()
    }

    @Provides
    fun provideGetRaceListUseCase(
        raceRepository: RaceRepository,
        flagRepository: FlagRepository,
        formatWeekendDateUseCase: FormatWeekendDateUseCase
    )
            : GetRaceListUseCase {
        return GetRaceListUseCase(raceRepository, flagRepository, formatWeekendDateUseCase)
    }

    @Provides
    fun provideGetRaceDetailByIdUseCase(
        formatWeekendDateUseCase: FormatWeekendDateUseCase,
        formatWeekendTimeUseCase: FormatWeekendTimeUseCase,
        circuitRepository: CircuitRepository
    )
            : GetRaceDetailByIdUseCase {
        return GetRaceDetailByIdUseCase(
            formatWeekendDateUseCase, formatWeekendTimeUseCase,
            circuitRepository
        )
    }
}