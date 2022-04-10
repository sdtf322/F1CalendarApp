package com.example.f1calendarOP

import java.io.Serializable

data class RaceF1(val dateF1: String, val trackF1: String, val flagImage: Int, val session1Time: String,
val session2Time: String, val session3Time: String, val session4Time: String, val session5Time: String) : Serializable