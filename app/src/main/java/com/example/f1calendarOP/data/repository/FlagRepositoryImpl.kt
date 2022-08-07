package com.example.f1calendarOP.data.repository

import com.example.f1calendarOP.R
import com.example.f1calendarOP.domain.models.RaceModel
import com.example.f1calendarOP.domain.repository.FlagRepository

class FlagRepositoryImpl : FlagRepository {

    override fun addFlagsByCountry(race : RaceModel) : Int{ // List and Detail screen
        val flagDrawable = when(race.circuit.location.country){ // Race Country
            "Bahrain" -> R.drawable.flag_bahrain
            "Australia" -> -R.drawable.flag_australia
            "Austria" -> R.drawable.flag_austria
            "Italy" -> R.drawable.flag_italy
            "USA" -> R.drawable.flag_us
            "Spain" -> R.drawable.flag_spain
            "Monaco" -> R.drawable.flag_monaco
            "Azerbaijan" -> R.drawable.flag_azerbaijan
            "Canada" -> R.drawable.flag_canada
            "UK" -> R.drawable.flag_uk
            "France" -> R.drawable.flag_france
            "Hungary" -> R.drawable.flag_hungary
            "Belgium" -> R.drawable.flag_belgium
            "Netherlands" -> R.drawable.flag_netherlands
            "Singapore" -> R.drawable.flag_singapore
            "Japan" -> R.drawable.flag_japan
            "Mexico" -> R.drawable.flag_mexico
            "Brazil" -> R.drawable.flag_brazil
            "UAE" -> R.drawable.flag_uae
            "Saudi Arabia" -> R.drawable.flag_saudi

            else -> R.drawable.flag_unknown
        }
        return flagDrawable
    }
}