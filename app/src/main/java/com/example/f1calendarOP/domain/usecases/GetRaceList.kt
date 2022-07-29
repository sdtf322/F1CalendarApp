package com.example.f1calendarOP.domain.usecases

import com.example.f1calendarOP.domain.models.RaceModel
import com.example.f1calendarOP.domain.repository.RaceRepository

class GetRaceList(private val raceRepository: RaceRepository) {

    fun execute() : List<RaceModel> {

        return raceRepository.getRaceList()
    }

}