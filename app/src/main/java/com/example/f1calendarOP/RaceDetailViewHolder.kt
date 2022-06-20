package com.example.f1calendarOP

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.f1calendarOP.databinding.ItemDetailCircuitBinding
import com.example.f1calendarOP.databinding.ItemDetailHeaderBinding
import com.example.f1calendarOP.databinding.ItemDetailSessionBinding


sealed class RaceDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    class HeaderViewHolder(private val binding : ItemDetailHeaderBinding) :
        RecyclerView.ViewHolder(binding.root){
         fun bind(item: RaceDetailModel.Header) {
             binding.tvTrackDetailF1.text = item.track
             binding.tvDateF12.text = item.date
             binding.flagDetailF1.setImageResource(item.flag)
        }
    }
    class SessionViewHolder(private val binding : ItemDetailSessionBinding) :
        RecyclerView.ViewHolder(binding.root){
         fun bind(item: RaceDetailModel.Session) {
             binding.tvSessionDate.text = item.sessionDate
             binding.tvSessionName.text = item.sessionName
             binding.tvSessionTime.text = item.sessionTime
        }
    }
    class CircuitViewHolder(private val binding : ItemDetailCircuitBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(item: RaceDetailModel.Circuit) {
            binding.circuitImage.setImageResource(item.circuitImage)
            binding.tvCircuitFirstGPYear.text = item.firstYear.toString()
            binding.tvCircuitLaps.text = item.laps.toString()
            binding.tvCircuitLength.text = item.circuitLength
            binding.tvCircuitDistance.text = item.raceDistance
            binding.tvCircuitLapRecord.text = item.lapRecord
            binding.tvCircuitLapRecordHolder.text = item.lapRecordOwner
        }
    }
}