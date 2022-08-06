package com.example.f1calendarOP.domain.repository

import com.example.f1calendarOP.domain.models.RaceDetailModel

interface RaceDetailRepository {

    fun getRaceDetailById() : ArrayList<RaceDetailModel>
}