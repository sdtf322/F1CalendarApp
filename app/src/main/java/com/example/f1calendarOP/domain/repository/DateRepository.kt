package com.example.f1calendarOP.domain.repository

import com.example.f1calendarOP.domain.models.RaceModel

interface DateRepository {

    fun formatWeekendDate(race : RaceModel) : String
}