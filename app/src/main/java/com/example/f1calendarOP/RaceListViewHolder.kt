package com.example.f1calendarOP

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.f1calendarOP.databinding.ItemRaceListBinding
import com.example.f1calendarOP.domain.models.Race

sealed class RaceListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    class MyViewHolder(private val binding: ItemRaceListBinding)
        : RecyclerView.ViewHolder(binding.root) {

            fun bind(race : Race){
                binding.trackF1.text = race.raceName
                binding.dateF1.text = race.weekendDate

                Glide.with(itemView)
                    .load(race.flagImage)
                    .placeholder(R.drawable.flag_unknown)
                    .error(R.drawable.flag_error)
                    .fallback(R.drawable.flag_error)
                    .into(binding.flagImage)
            }
        }
    }