package com.example.f1calendarOP.presentation.racelist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.f1calendarOP.R
import com.example.f1calendarOP.databinding.ItemRaceListBinding
import com.example.f1calendarOP.domain.models.RaceModel

sealed class RaceListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    class MyViewHolder(private val binding: ItemRaceListBinding)
        : RecyclerView.ViewHolder(binding.root) {

            fun bind(raceModel : RaceModel){
                binding.trackF1.text = raceModel.raceName
                binding.dateF1.text = raceModel.weekendDate

                Glide.with(itemView)
                    .load(raceModel.flagImage)
                    .placeholder(R.drawable.flag_unknown)
                    .error(R.drawable.flag_error)
                    .fallback(R.drawable.flag_error)
                    .into(binding.flagImage)
            }
        }
    }