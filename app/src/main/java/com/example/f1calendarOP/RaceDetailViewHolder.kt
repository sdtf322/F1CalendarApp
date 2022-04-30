package com.example.f1calendarOP

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

    sealed class RaceDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(item: RaceDetailModel.Header) {
                itemView.findViewById<TextView>(R.id.tvTrackDetailF1).text = item.track
                itemView.findViewById<TextView>(R.id.tvDateF1_2).text = item.date
                itemView.findViewById<ImageView>(R.id.flagDetailF1)?.setImageResource(item.flag)
            }
        }

        class SessionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            fun bind(item: RaceDetailModel.Session){
                itemView.findViewById<TextView>(R.id.tvSessionDate).text = item.sessionDate
                itemView.findViewById<TextView>(R.id.tvSessionName).text = item.sessionName
                itemView.findViewById<TextView>(R.id.tvSessionTime).text = item.sessionTime
            }
        }
    }



