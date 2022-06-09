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
        private val headerTrack : TextView = itemView.findViewById(R.id.tvTrackDetailF1)
        private val headerDate : TextView = itemView.findViewById(R.id.tvDateF1_2)
        private val headerFlag : ImageView = itemView.findViewById(R.id.flagDetailF1)
         fun bind(item: RaceDetailModel.Header) {
             headerTrack.text = item.track
             headerDate.text = item.date
             headerFlag.setImageResource(item.flag)
        }
    }
    class SessionViewHolder(private val binding : ItemDetailSessionBinding) :
        RecyclerView.ViewHolder(binding.root){
        private val sessionDate : TextView = itemView.findViewById(R.id.tvSessionDate)
        private val sessionName : TextView = itemView.findViewById(R.id.tvSessionName)
        private val sessionTime : TextView = itemView.findViewById(R.id.tvSessionTime)
         fun bind(item: RaceDetailModel.Session) {
             sessionDate.text = item.sessionDate
             sessionName.text = item.sessionName
             sessionTime.text = item.sessionTime
        }
    }
    class CircuitViewHolder(private val binding : ItemDetailCircuitBinding) :
        RecyclerView.ViewHolder(binding.root){
        private val circuitImage : ImageView = itemView.findViewById(R.id.circuitImage)
        private val firstYear : TextView = itemView.findViewById(R.id.tvCircuitFirstGPYear)
        private val laps : TextView = itemView.findViewById(R.id.tvCircuitLaps)
        private val length : TextView = itemView.findViewById(R.id.tvCircuitLength)
        private val totalDistance : TextView = itemView.findViewById(R.id.tvCircuitDistance)
        private val lapRecord : TextView = itemView.findViewById(R.id.tvCircuitLapRecord)
        private val lapRecordOwner : TextView = itemView.findViewById(R.id.tvCircuitLapRecordHolder)
        fun bind(item: RaceDetailModel.Circuit) {
            circuitImage.setImageResource(item.circuitImage)
            firstYear.text = item.firstYear.toString()
            laps.text = item.laps.toString()
            length.text = item.circuitLength
            totalDistance.text = item.raceDistance.toString()
            lapRecord.text = item.lapRecord
            lapRecordOwner.text = item.lapRecordOwner
        }
    }
}