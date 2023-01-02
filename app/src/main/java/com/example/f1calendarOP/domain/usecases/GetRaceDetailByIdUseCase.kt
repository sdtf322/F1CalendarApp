package com.example.f1calendarOP.domain.usecases

import com.example.f1calendarOP.domain.models.RaceDetailModel
import com.example.f1calendarOP.domain.models.RaceModel
import com.example.f1calendarOP.domain.repository.CircuitRepository

class GetRaceDetailByIdUseCase(
    private val dateFormatter: FormatWeekendDateUseCase,
    private val timeFormatter: FormatWeekendTimeUseCase,
    private val circuitRepository: CircuitRepository
) {

    operator fun invoke(raceModel: RaceModel): ArrayList<RaceDetailModel> {

        val raceDetailList = ArrayList<RaceDetailModel>()
        val flagImage = raceModel.flagImage

        val weekendDate = raceModel.weekendDate
        val header = RaceDetailModel.Header(
            track = raceModel.raceName, date = weekendDate!!, flag = flagImage!!
        )
        raceDetailList.add(header)

        val secondPracticeDate = dateFormatter.formatDetailDate(raceModel.secondPractice.date)
        val secondPracticeTime = timeFormatter(raceModel.secondPractice.time)
        val secondPractice = RaceDetailModel.Session(
            sessionDate = secondPracticeDate, sessionName = "Practice 2",
            sessionTime = secondPracticeTime
        )

        val qualificationDate = dateFormatter.formatDetailDate(raceModel.qualifying.date)
        val qualificationTime = timeFormatter(raceModel.qualifying.time)
        val qualification = RaceDetailModel.Session(
            sessionDate = qualificationDate, sessionName = "Qualification",
            sessionTime = qualificationTime
        )

        val session2: RaceDetailModel.Session
        val session3: RaceDetailModel.Session
        val session4: RaceDetailModel.Session


        if (raceModel.sprint != null) {
            val sprintDate = dateFormatter.formatDetailDate(raceModel.sprint.date)
            val sprintTime = timeFormatter(raceModel.sprint.time)
            session2 = qualification
            session3 = secondPractice
            session4 = RaceDetailModel.Session( // Sprint
                sessionDate = sprintDate, sessionName = "Sprint",
                sessionTime = sprintTime
            )
        } else {
            session2 = secondPractice
            val thirdPracticeDate = dateFormatter.formatDetailDate(raceModel.thirdPractice!!.date)
            val thirdPracticeTime = timeFormatter(raceModel.thirdPractice.time)
            session3 = RaceDetailModel.Session( // Third Practice
                sessionDate = thirdPracticeDate, sessionName = "Practice 3",
                sessionTime = thirdPracticeTime
            )
            session4 = qualification
        }


        val firstPracticeDate = dateFormatter.formatDetailDate(raceModel.firstPractice.date)
        val firstPracticeTime = timeFormatter(raceModel.firstPractice.time)
        val session1 = RaceDetailModel.Session(
            sessionDate = firstPracticeDate, sessionName = "Practice 1",
            sessionTime = firstPracticeTime
        )

        val raceDate = dateFormatter.formatDetailDate(raceModel.date)
        val raceTime = timeFormatter(raceModel.time)
        val session5 = RaceDetailModel.Session(
            sessionDate = raceDate, sessionName = "Race",
            sessionTime = raceTime
        )

        val raceCircuit = circuitRepository.getCircuitData(raceModel.circuit.circuitName)

        raceDetailList.apply {
            add(session1)
            add(session2)
            add(session3)
            add(session4)
            add(session5)
            add(raceCircuit)
        }
        return raceDetailList

    }
}