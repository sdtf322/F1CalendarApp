package com.example.f1calendarOP

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.f1calendarOP.databinding.ItemRaceListBinding

sealed class RaceListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    class MyViewHolder(
        private val binding: ItemRaceListBinding,
        private val onClickHelper: (position : Int) -> Unit)
        : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener { _ ->
                onClickHelper(adapterPosition)
            }
        }
            private val trackF1 = itemView.findViewById<TextView>(R.id.trackF1)
            private val dateF1 = itemView.findViewById<TextView>(R.id.dateF1)
            private val flagImage = itemView.findViewById<ImageView>(R.id.flagImage)
            fun bind(race : Race){
                trackF1.text = race.raceName
                dateF1.text = race.weekendDate

                Glide.with(itemView)
                    .load(race.flagImage)
                    .placeholder(R.drawable.flag_unknown)
                    .error(R.drawable.flag_error)
                    .fallback(R.drawable.flag_error)
                    .into(flagImage)
            }
        }
    }