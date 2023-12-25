package com.example.f1calendarOP.domain.usecases

import com.example.f1calendarOP.domain.models.RaceModel
import com.example.f1calendarOP.domain.repository.FlagRepository
import com.example.f1calendarOP.domain.repository.RaceRepository

class GetRaceListUseCase(
    private val raceRepository: RaceRepository,
    private val flagRepository: FlagRepository,
    private val dateFormatter: FormatWeekendDateUseCase
) {

    suspend operator fun invoke(): List<RaceModel> {

        val raceRepositoryRaceList = raceRepository.getRaceList()

        for (item in raceRepositoryRaceList) {
            item.flagImage = flagRepository.addFlagsByCountry(item)
            item.weekendDate = dateFormatter.setListDate(item)
        }

        return raceRepositoryRaceList
    }
}