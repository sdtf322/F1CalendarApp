package com.example.f1calendarOP.domain.repository

import com.example.f1calendarOP.domain.models.RaceModel

interface FlagRepository {

    fun addFlagsByCountry(race : RaceModel) : Int
}