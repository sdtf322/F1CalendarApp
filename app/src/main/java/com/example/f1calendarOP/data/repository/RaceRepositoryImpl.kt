package com.example.f1calendarOP.data.repository

import com.example.f1calendarOP.data.models.Race
import com.example.f1calendarOP.data.network.RaceApi
import com.example.f1calendarOP.domain.models.Circuit
import com.example.f1calendarOP.domain.models.RaceModel
import com.example.f1calendarOP.domain.models.Location
import com.example.f1calendarOP.domain.models.FirstPractice
import com.example.f1calendarOP.domain.models.SecondPractice
import com.example.f1calendarOP.domain.models.ThirdPractice
import com.example.f1calendarOP.domain.models.Sprint
import com.example.f1calendarOP.domain.models.Qualifying
import com.example.f1calendarOP.domain.repository.RaceRepository
import javax.inject.Inject

class RaceRepositoryImpl @Inject constructor(
    private val raceApi: RaceApi
) : RaceRepository {

    override suspend fun getRaceList(): List<RaceModel> {

        val dataRaceList =
            raceApi.getRaceList()

        return raceListMapToDomain(dataRaceList)
    }

    private fun raceListMapToDomain(raceList: List<Race>): List<RaceModel> {

        val raceModelList = mutableListOf<RaceModel>()

        for (item in raceList) {
            raceModelList.add(raceMapToDomain(item))
        }

        return raceModelList
    }

    private fun raceMapToDomain(race: Race): RaceModel {
        with(race) {
            return RaceModel(
                circuit = circuitMap(race),
                date = date,
                firstPractice = firstPracticeMap(race),
                flagImage = flagImage,
                qualifying = qualifyingMap(race),
                raceName = raceName,
                round = round,
                season = season,
                secondPractice = secondPracticeMap(race),
                time = time,
                url = url,
                weekendDate = weekendDate,
                sprint = sprint?.let {
                    Sprint(
                        date = it.date,
                        time = it.time
                    )
                },
                thirdPractice = thirdPractice?.let {
                    ThirdPractice(
                        date = it.date,
                        time = it.time
                    )
                }
            )
        }
    }

    private fun locationMap(race: Race): Location {
        with(race.circuit.location) {
            return Location(
                country = country,
                lat = lat,
                locality = locality,
                long = long
            )
        }
    }

    private fun circuitMap(race: Race): Circuit {
        with(race.circuit) {
            return Circuit(
                circuitId = circuitId,
                circuitName = circuitName,
                location = locationMap(race),
                url = url
            )
        }
    }

    private fun firstPracticeMap(race: Race): FirstPractice {
        with(race.firstPractice) {
            return FirstPractice(
                date = date,
                time = time
            )
        }
    }

    private fun secondPracticeMap(race: Race): SecondPractice {
        with(race.secondPractice) {
            return SecondPractice(
                date = date,
                time = time
            )
        }
    }

    private fun qualifyingMap(race: Race): Qualifying {
        with(race.qualifying) {
            return Qualifying(
                date = date,
                time = time
            )
        }
    }
}