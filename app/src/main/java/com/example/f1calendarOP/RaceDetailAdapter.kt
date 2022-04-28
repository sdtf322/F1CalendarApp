package com.example.f1calendarOP

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalArgumentException

// TODO:
// -move detail viewholder to a new class
// -add views in detail fragment

class RaceDetailAdapter : RecyclerView.Adapter<RaceDetailAdapterViewHolder>() {

    private val raceDetail = ArrayList<RaceDetailModel>()

    fun updateList(raceDetail: List<RaceDetailModel>) {
        this.raceDetail.clear()
        this.raceDetail.addAll(raceDetail)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RaceDetailAdapterViewHolder {
        val layout = when (viewType) {
            TYPE_SESSION -> R.layout.item_detail_session
            TYPE_HEADER -> R.layout.item_detail_header

            else -> throw IllegalArgumentException("Invalid view type")
        }

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return RaceDetailAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: RaceDetailAdapterViewHolder, position: Int) {
        holder.bind(raceDetail[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when (raceDetail[position]) {
            is RaceDetailModel.Session -> TYPE_SESSION
            is RaceDetailModel.Header -> TYPE_HEADER
        }
    }

    companion object {
        val TYPE_SESSION = R.layout.item_detail_session
        val TYPE_HEADER = R.layout.item_detail_header
    }

    override fun getItemCount(): Int = raceDetail.size

    }