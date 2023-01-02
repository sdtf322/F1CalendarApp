package com.example.f1calendarOP.presentation.racelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.ListAdapter
import com.example.f1calendarOP.databinding.ItemRaceListBinding
import com.example.f1calendarOP.domain.models.RaceModel
import com.example.f1calendarOP.utils.raceModelDiffCallback

class RaceListAdapter(private val onClickHelper : (RaceModel) -> Unit) :
        ListAdapter<RaceModel, RaceListViewHolder.MyViewHolder>
            (raceModelDiffCallback) {
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RaceListViewHolder.MyViewHolder {
        return RaceListViewHolder.MyViewHolder(
            ItemRaceListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: RaceListViewHolder.MyViewHolder, position: Int) {
        val race = getItem(position)
        holder.itemView.setOnClickListener {
            onClickHelper(race)
        }
        holder.bind(race)
    }
}