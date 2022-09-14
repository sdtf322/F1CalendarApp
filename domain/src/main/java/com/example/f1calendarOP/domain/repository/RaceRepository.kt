package com.example.f1calendarOP.domain.repository

import com.example.f1calendarOP.domain.models.RaceModel

interface RaceRepository {

    suspend fun getRaceList() : List<RaceModel>

}