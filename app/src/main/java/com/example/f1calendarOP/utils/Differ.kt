package com.example.f1calendarOP.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.f1calendarOP.domain.models.RaceModel

val raceModelDiffCallback = object : DiffUtil.ItemCallback<RaceModel>(){
        override fun areItemsTheSame(oldItem: RaceModel, newItem: RaceModel): Boolean {
            return oldItem.round == newItem.round
        }
        override fun areContentsTheSame(oldItem: RaceModel, newItem: RaceModel): Boolean {
            return oldItem == newItem
        }
    }

