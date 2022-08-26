package com.example.f1calendarOP.di

import com.example.f1calendarOP.data.network.RaceApi
import com.example.f1calendarOP.data.network.RaceNetworkData
import com.example.f1calendarOP.data.repository.CircuitRepositoryImpl
import com.example.f1calendarOP.data.repository.FlagRepositoryImpl
import com.example.f1calendarOP.data.repository.RaceRepositoryImpl
import com.example.f1calendarOP.domain.repository.CircuitRepository
import com.example.f1calendarOP.domain.repository.FlagRepository
import com.example.f1calendarOP.domain.repository.RaceRepository
import dagger.Binds
import dagger.Module

@Module(includes = [DataBindModule::class])
class DataModule

@Module
interface DataBindModule {

    @Binds
    fun bindRaceRepository(raceRepositoryImpl: RaceRepositoryImpl) : RaceRepository

    @Binds
    fun bindFlagRepository(flagRepositoryImpl: FlagRepositoryImpl) : FlagRepository

    @Binds
    fun bindCircuitRepository(circuitRepositoryImpl: CircuitRepositoryImpl) : CircuitRepository

    @Binds
    fun bindRaceApi(raceNetworkData: RaceNetworkData) : RaceApi

}