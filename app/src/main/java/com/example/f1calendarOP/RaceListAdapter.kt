package com.example.f1calendarOP

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.f1calendarOP.databinding.ItemRaceListBinding

    class RaceListAdapter(private val onClickListener: OnClickListener) :
        RecyclerView.Adapter<RaceListViewHolder.MyViewHolder>() {

    private val differ = AsyncListDiffer(this, diffCallback)

    var raceList : List<Race>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RaceListViewHolder.MyViewHolder {
        return RaceListViewHolder.MyViewHolder(ItemRaceListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }
    override fun onBindViewHolder(holder: RaceListViewHolder.MyViewHolder, position: Int) {

        val race = raceList[position]
        holder.itemView.setOnClickListener {
            onClickListener.onClick(race)
        }
        holder.bind(raceList[position])
    }

    override fun getItemCount(): Int {
        return raceList.size
    }

    class OnClickListener(val clickListener: (race: Race) -> Unit) {
        fun onClick(race: Race) = clickListener(race)
    }
}