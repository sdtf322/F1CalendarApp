package com.example.f1calendarOP

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.ListAdapter
import com.example.f1calendarOP.databinding.ItemRaceListBinding

    class RaceListAdapter(private val onClickHelper: (position: Int) -> Unit) :
        ListAdapter<Race, RaceListViewHolder.MyViewHolder>
            (raceDiffCallback) {

    private val raceDiffer = AsyncListDiffer(this, raceDiffCallback)

    var raceList : List<Race>
        get() = raceDiffer.currentList
        set(value) {raceDiffer.submitList(value)}

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RaceListViewHolder.MyViewHolder {
        return RaceListViewHolder.MyViewHolder(ItemRaceListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ), onClickHelper)
    }
    override fun onBindViewHolder(holder: RaceListViewHolder.MyViewHolder, position: Int) {
        holder.bind(raceList[position])
    }

    override fun getItemCount(): Int {
        return raceList.size
    }

//    class OnClickListener(val clickListener: (race: Race) -> Unit) {
//        fun onClick(race: Race) = clickListener(race)
//    }
}