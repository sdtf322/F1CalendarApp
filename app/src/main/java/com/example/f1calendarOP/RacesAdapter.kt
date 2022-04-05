package com.example.f1calendarOP

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

internal class RacesAdapter(
    private var raceList: List<RaceF1>,
    val listener:MyOnClickListener
    ) :
    RecyclerView.Adapter<RacesAdapter.MyViewHolder>() {

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var dateF1: TextView = view.findViewById(R.id.dateF1)
        var trackF1: TextView = view.findViewById(R.id.trackF1)
        var roundF1: TextView = view.findViewById(R.id.roundF1)
        var flagImage: ImageView = view.findViewById(R.id.flagImage)

        fun initialize(race: RaceF1, action:MyOnClickListener){
            dateF1.text = race.getDateF1()
            trackF1.text = race.getTrackF1()
            roundF1.text = race.getRoundF1()
            flagImage.setImageResource(race.getFlagImageF1()!!)

            itemView.setOnClickListener {
                action.OnClick(race, adapterPosition)
            }
        }

    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.initialize(raceList.get(position), listener)
    }
    override fun getItemCount(): Int {
        return raceList.size
    }

    interface MyOnClickListener{
        fun OnClick(race:RaceF1,position: Int)
    }

}