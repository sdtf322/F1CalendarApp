package com.example.f1calendarOP

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
class RacesAdapter(
    val listener:MyOnClickListener
    ) :
    RecyclerView.Adapter<RacesAdapter.MyViewHolder>() {
    private var raceList: MutableList<RaceF1> = mutableListOf()
    fun updateList(racelist: List<RaceF1>){
        this.raceList.clear()
        this.raceList.addAll(racelist)
        notifyDataSetChanged()
    }
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var dateF1: TextView = view.findViewById(R.id.dateF1)
        var trackF1: TextView = view.findViewById(R.id.trackF1)
        var flagImage: ImageView = view.findViewById(R.id.flagImage)

        fun initialize(race: RaceF1, action:MyOnClickListener){
            dateF1.text = race.dateF1
            trackF1.text = race.trackF1
            flagImage.setImageResource(race.flagImage)

            itemView.setOnClickListener {
                action.onClick(race, adapterPosition)
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
        fun onClick(race:RaceF1,position: Int)
    }

}