package com.example.f1calendarOP.di

import com.example.f1calendarOP.presentation.MainActivity
import com.example.f1calendarOP.presentation.racedetail.RaceDetailFragment
import com.example.f1calendarOP.presentation.racelist.RaceListFragment
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(raceListFragment: RaceListFragment)

    fun inject(raceDetailFragment: RaceDetailFragment)

}