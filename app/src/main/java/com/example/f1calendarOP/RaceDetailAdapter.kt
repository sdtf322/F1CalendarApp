package com.example.f1calendarOP

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.f1calendarOP.databinding.ItemDetailCircuitBinding
import com.example.f1calendarOP.databinding.ItemDetailHeaderBinding
import com.example.f1calendarOP.databinding.ItemDetailSessionBinding
import java.lang.IllegalArgumentException


class RaceDetailAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var raceDetail = ArrayList<RaceDetailModel>()

    fun setRaceDetailList(raceList : ArrayList<RaceDetailModel>){
        this.raceDetail = raceList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        return when(viewType){
            R.layout.item_detail_header -> RaceDetailViewHolder.HeaderViewHolder(
                ItemDetailHeaderBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
            )
            R.layout.item_detail_session -> RaceDetailViewHolder.SessionViewHolder(
                ItemDetailSessionBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
            )
            R.layout.item_detail_circuit -> RaceDetailViewHolder.CircuitViewHolder(
                ItemDetailCircuitBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
            )
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is RaceDetailViewHolder.HeaderViewHolder -> holder.bind(raceDetail[position] as RaceDetailModel.Header)
            is RaceDetailViewHolder.SessionViewHolder -> holder.bind(raceDetail[position] as RaceDetailModel.Session)
            is RaceDetailViewHolder.CircuitViewHolder -> holder.bind(raceDetail[position] as RaceDetailModel.Circuit)
        }
    }
    override fun getItemViewType(position: Int): Int {
        return when (raceDetail[position]) {
            is RaceDetailModel.Session -> R.layout.item_detail_session
            is RaceDetailModel.Header -> R.layout.item_detail_header
            is RaceDetailModel.Circuit -> R.layout.item_detail_circuit
        }
    }
    override fun getItemCount(): Int = raceDetail.size

    }