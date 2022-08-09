package com.example.f1calendarOP.di

import com.example.f1calendarOP.data.network.RaceApi
import com.example.f1calendarOP.data.network.RaceNetworkData
import com.example.f1calendarOP.data.repository.CircuitRepositoryImpl
import com.example.f1calendarOP.data.repository.FlagRepositoryImpl
import com.example.f1calendarOP.data.repository.RaceRepositoryImpl
import com.example.f1calendarOP.domain.repository.CircuitRepository
import com.example.f1calendarOP.domain.repository.FlagRepository
import com.example.f1calendarOP.domain.repository.RaceRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideRaceApi() : RaceApi {
        return RaceNetworkData()
    }

    @Provides
    fun provideRaceRepository(raceApi: RaceApi) : RaceRepository {
        return RaceRepositoryImpl(raceApi = raceApi)
    }

    @Provides
    fun provideFlagRepository() : FlagRepository {
        return FlagRepositoryImpl()
    }

    @Provides
    fun provideCircuitRepository() : CircuitRepository {
        return CircuitRepositoryImpl()
    }
}