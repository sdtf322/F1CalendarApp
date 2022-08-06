package com.example.f1calendarOP.domain.repository

import com.example.f1calendarOP.domain.models.RaceDetailModel

interface CircuitRepository {

    fun getCircuitData(trackName : String) : RaceDetailModel.Circuit
}