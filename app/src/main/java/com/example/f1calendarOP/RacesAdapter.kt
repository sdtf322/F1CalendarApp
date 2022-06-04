package com.example.f1calendarOP

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.f1calendarOP.databinding.ItemRaceListBinding

class RacesAdapter(val onClickListener: OnClickListener) :
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
    private val raceFunctions = RaceFunctions()

    private val differ = AsyncListDiffer(this, diffCallback)

    var raceList : List<Race>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemRaceListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val race = raceList[position]
        val raceCountry = race.Circuit.Location.country
        val formattedDate = raceFunctions.formatDate(race.date)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(race)
        }
        holder.binding.apply{
            trackF1.text = race.raceName
            dateF1.text = formattedDate
            raceFunctions.BindFlagByCountry(raceCountry, flagImage)
        }

    }
    override fun getItemCount(): Int {
        return raceList.size
    }

    class OnClickListener(val clickListener: (race: Race) -> Unit) {
        fun onClick(race: Race) = clickListener(race)
    }
}