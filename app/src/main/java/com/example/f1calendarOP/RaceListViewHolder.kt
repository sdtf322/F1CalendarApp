package com.example.f1calendarOP

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.f1calendarOP.databinding.ItemRaceListBinding

sealed class RaceListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    class MyViewHolder(private val binding: ItemRaceListBinding)
        : RecyclerView.ViewHolder(binding.root) {

            private val trackF1 = itemView.findViewById<TextView>(R.id.trackF1)
            private val dateF1 = itemView.findViewById<TextView>(R.id.dateF1)
            private val flagImage = itemView.findViewById<ImageView>(R.id.flagImage)
            fun bind(race : Race){
                trackF1.text = race.raceName
                dateF1.text = race.weekendDate
                flagImage.setImageResource(race.flagImage)
            }
        }
    }