package com.example.f1calendarOP.domain.usecases

import com.example.f1calendarOP.domain.models.RaceDetailModel
import com.example.f1calendarOP.domain.repository.RaceDetailRepository

class GetRaceDetailByIdUseCase(private val raceDetailRepository: RaceDetailRepository) {

    operator fun invoke() : ArrayList<RaceDetailModel> {
        TODO()
    }
}