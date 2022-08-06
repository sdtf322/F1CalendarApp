package com.example.f1calendarOP.data.storage

import com.example.f1calendarOP.R
import com.example.f1calendarOP.domain.models.RaceDetailModel

class CircuitStorage {

    fun getCircuitData(track: String): RaceDetailModel.Circuit { // Detail screen
        val firstYear: Int
        val laps: Int
        val circuitLength: String
        val lapRecord: String
        val lapRecordOwner: String
        val circuitDrawable: Int
        when (track) {
            "Bahrain International Circuit" -> {
                circuitDrawable = R.drawable.circuit_bahrain
                firstYear = 1967; laps = 57; circuitLength = "5.412"
                lapRecord = "1:31.447"; lapRecordOwner = "Pedro de la Rosa (2005)"
            }
            "Jeddah Corniche Circuit" -> {
                circuitDrawable = R.drawable.circuit_jeddah
                firstYear = 2021; laps = 50; circuitLength = "6.174"
                lapRecord = "1:30.734"; lapRecordOwner = "Lewis Hamilton (2021)"
            }
            "Albert Park Grand Prix Circuit" -> {
                circuitDrawable = R.drawable.circuit_australia
                firstYear = 1996; laps = 58; circuitLength = "5.278"
                lapRecord = "1:24.125"; lapRecordOwner = "Michael Schumacher (2004)"
            }
            "Autodromo Enzo e Dino Ferrari" -> {
                circuitDrawable = R.drawable.circuit_imola
                firstYear = 1980; laps = 63; circuitLength = "4.909"
                lapRecord = "1:15.484"; lapRecordOwner = "Lewis Hamilton (2020)"
            }
            "Circuit of the Americas" -> {
                circuitDrawable = R.drawable.circuit_usa
                firstYear = 2012; laps = 56; circuitLength = "5.513"
                lapRecord = "1:36.169"; lapRecordOwner = "Charles Leclerc (2019)"
            }
            "Baku City Circuit" -> {
                circuitDrawable = R.drawable.circuit_azerbaijan
                firstYear = 2016; laps = 51; circuitLength = "6.003"
                lapRecord = "1:43.009"; lapRecordOwner = "Charles Leclerc (2019)"
            }
            "Circuit de Barcelona-Catalunya" -> {
                circuitDrawable = R.drawable.circuit_catalunya
                firstYear = 1991; laps = 66; circuitLength = "4.675"
                lapRecord = "1:18.149"; lapRecordOwner = "Max Verstappen (2021)"
            }
            "Hungaroring" -> {
                circuitDrawable = R.drawable.circuit_hungaroring
                firstYear = 1986; laps = 70; circuitLength = "4.381"
                lapRecord = "1:16.627"; lapRecordOwner = "Lewis Hamilton (2020)"
            }
            "Autódromo José Carlos Pace" -> {
                circuitDrawable = R.drawable.circuit_brazil
                firstYear = 1973; laps = 71; circuitLength = "4.309"
                lapRecord = "1:10.540"; lapRecordOwner = "Valtteri Bottas (2018)"
            }
            "Marina Bay Street Circuit" -> {
                circuitDrawable = R.drawable.circuit_singapore
                firstYear = 2008; laps = 61; circuitLength = "5.063"
                lapRecord = "1:41.905"; lapRecordOwner = "Kevin Magnussen (2018)"
            }
            "Miami International Autodrome" -> {
                circuitDrawable = R.drawable.circuit_miami
                firstYear = 2022; laps = 57; circuitLength = "5.142"
                lapRecord = "1:31.361"; lapRecordOwner = "Max Verstappen (2022)"
            }
            "Circuit de Monaco" -> {
                circuitDrawable = R.drawable.circuit_monaco
                firstYear = 1950; laps = 78; circuitLength = "3.337"
                lapRecord = "1:12.909"; lapRecordOwner = "Lewis Hamilton (2021)"
            }
            "Autodromo Nazionale di Monza" -> {
                circuitDrawable = R.drawable.circuit_monza
                firstYear = 1950; laps = 53; circuitLength = "5.793"
                lapRecord = "1:21.046"; lapRecordOwner = "Rubens Barrichello (2004)"
            }
            "Red Bull Ring" -> {
                circuitDrawable = R.drawable.circuit_austria
                firstYear = 1970; laps = 71; circuitLength = "4.318"
                lapRecord = "1:05.619"; lapRecordOwner = "Carlos Sainz (2020)"
            }
            "Circuit Paul Ricard" -> {
                circuitDrawable = R.drawable.circuit_france
                firstYear = 1971; laps = 53; circuitLength = "5.842"
                lapRecord = "1:32.740"; lapRecordOwner = "Sebastian Vettel (2019)"
            }
            "Autódromo Hermanos Rodríguez" -> {
                circuitDrawable = R.drawable.circuit_mexico
                firstYear = 1963; laps = 71; circuitLength = "4.304"
                lapRecord = "1:17.774"; lapRecordOwner = "Valtteri Bottas (2021)"
            }
            "Silverstone Circuit" -> {
                circuitDrawable = R.drawable.circuit_silverstone
                firstYear = 1950; laps = 52; circuitLength = "5.891"
                lapRecord = "1:27.097"; lapRecordOwner = "Max Verstappen (2020)"
            }
            "Circuit de Spa-Francorchamps" -> {
                circuitDrawable = R.drawable.circuit_spa
                firstYear = 1950; laps = 44; circuitLength = "7.004"
                lapRecord = "1:46.286"; lapRecordOwner = "Valtteri Bottas (2018)"
            }
            "Suzuka Circuit" -> {
                circuitDrawable = R.drawable.circuit_suzuka
                firstYear = 1987; laps = 53; circuitLength = "5.807"
                lapRecord = "1:30.983"; lapRecordOwner = "Lewis Hamilton (2019)"
            }
            "Circuit Gilles Villeneuve" -> {
                circuitDrawable = R.drawable.circuit_canada
                firstYear = 1978; laps = 70; circuitLength = "4.361"
                lapRecord = "1:13.078"; lapRecordOwner = "Valtteri Bottas (2019)"
            }
            "Yas Marina Circuit" -> {
                circuitDrawable = R.drawable.circuit_abudhabi
                firstYear = 2009; laps = 58; circuitLength = "5.281"
                lapRecord = "1:26.103"; lapRecordOwner = "Max Verstappen (2021)"
            }
            "Circuit Park Zandvoort" -> {
                circuitDrawable = R.drawable.circuit_zandvoort
                firstYear = 1952; laps = 72; circuitLength = "4.259"
                lapRecord = "1:11.097"; lapRecordOwner = "Lewis Hamilton (2021)"
            }

            else -> {
                circuitDrawable = R.drawable.flag_error
                firstYear = 1950; laps = 100; circuitLength = "3.222"
                lapRecord = "1:00.000"; lapRecordOwner = "Jenson Button"
            }
        }
        val raceDistance = String.format("%.3f", circuitLength.toDouble() * laps).toDouble()

        return RaceDetailModel.Circuit(
            circuitImage = circuitDrawable,
            firstYear = firstYear,
            laps = laps,
            circuitLength = "$circuitLength km",
            raceDistance = "$raceDistance km",
            lapRecord = lapRecord,
            lapRecordOwner = lapRecordOwner
        )
    }
}