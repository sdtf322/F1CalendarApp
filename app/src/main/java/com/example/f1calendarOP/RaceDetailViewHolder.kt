package com.example.f1calendarOP

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.f1calendarOP.databinding.ItemDetailCircuitBinding
import com.example.f1calendarOP.databinding.ItemDetailHeaderBinding
import com.example.f1calendarOP.databinding.ItemDetailSessionBinding


sealed class RaceDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    class HeaderViewHolder(private val binding : ItemDetailHeaderBinding) :
        RecyclerView.ViewHolder(binding.root){
         fun bind(item: RaceDetailModel.Header) {
             with(binding){
                 tvTrackDetailF1.text = item.track
                 tvDateF12.text = item.date
                 flagDetailF1.setImageResource(item.flag)
             }
        }
    }
    class SessionViewHolder(private val binding : ItemDetailSessionBinding) :
        RecyclerView.ViewHolder(binding.root){
         fun bind(item: RaceDetailModel.Session) {
             with(binding){
                 tvSessionDate.text = item.sessionDate
                 tvSessionName.text = item.sessionName
                 tvSessionTime.text = item.sessionTime
             }
        }
    }
    class CircuitViewHolder(private val binding : ItemDetailCircuitBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(item: RaceDetailModel.Circuit) {
            with(binding){
                circuitImage.setImageResource(item.circuitImage)
                tvCircuitFirstGPYear.text = item.firstYear.toString()
                tvCircuitLaps.text = item.laps.toString()
                tvCircuitLength.text = item.circuitLength
                tvCircuitDistance.text = item.raceDistance.toString()
                tvCircuitLapRecord.text = item.lapRecord
                tvCircuitLapRecordHolder.text = item.lapRecordOwner
            }
        }
    }
}