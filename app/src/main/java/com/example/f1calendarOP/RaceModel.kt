package com.example.f1calendarOP

class RaceF1(dateF1: String?, trackF1: String?, roundF1: String?, flagImage: Int, session1Time: String?,
session2Time: String?, session3Time: String?, session4Time: String?,session5Time: String?) {
    private var dateF1: String
    private var trackF1: String
    private var roundF1: String
    private var flagImage: Int
    private var session1Time: String
    private var session2Time: String
    private var session3Time: String
    private var session4Time: String
    private var session5Time: String

    init {
        this.dateF1 = dateF1!!
        this.trackF1 = trackF1!!
        this.roundF1 = roundF1!!
        this.flagImage = flagImage
        this.session1Time = session1Time!!
        this.session2Time = session2Time!!
        this.session3Time = session3Time!!
        this.session4Time = session4Time!!
        this.session5Time = session5Time!!
    }
    fun getDateF1(): String {
        return dateF1
    }
    fun setDateF1(dateF1: String?) {
        this.dateF1 = dateF1!!
    }
    fun getTrackF1(): String? {
        return trackF1
    }
    fun setTrackF1(trackF1: String?) {
        this.trackF1 = trackF1!!
    }
    fun getRoundF1(): String? {
        return roundF1
    }
    fun setRoundF1(roundF1: String?) {
        this.roundF1 = roundF1!!
    }
    fun getFlagImageF1(): Int? {
        return flagImage
    }
    fun setFlagImage(flagImage: Int) {
        this.flagImage = flagImage!!
    }
    fun getSession1Time(): String?{
        return session1Time
    }
    fun getSession2Time(): String?{
        return session2Time
    }
    fun getSession3Time(): String?{
        return session3Time
    }
    fun getSession4Time(): String?{
        return session4Time
    }
    fun getSession5Time(): String?{
        return session5Time
    }
}