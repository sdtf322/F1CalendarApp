package com.example.f1calendarOP

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.f1calendarOP.databinding.ItemRaceListBinding

class RacesAdapter(
    val listener : MyOnClickListener) :
    RecyclerView.Adapter<RacesAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ItemRaceListBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Race>(){
        override fun areItemsTheSame(oldItem: Race, newItem: Race): Boolean {
            return oldItem.round == newItem.round
        }

        override fun areContentsTheSame(oldItem: Race, newItem: Race): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var raceList : List<Race>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

//    fun updateList(racelist: List<Race>){
//        this.raceList.clear()
//        this.raceList.addAll(racelist)
//        notifyDataSetChanged()
//    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_race_list, parent, false)
        return MyViewHolder(ItemRaceListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply{
            val race = raceList[position]
            trackF1.text = race.raceName
            dateF1.text = race.date
            flagImage.setImageResource(R.drawable.flag_austria)
        }

    }
    override fun getItemCount(): Int {
        return raceList.size
    }

    interface MyOnClickListener{
        fun onClick(race:Race,position: Int)
    }
}