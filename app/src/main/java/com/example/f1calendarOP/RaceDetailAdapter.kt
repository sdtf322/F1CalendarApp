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

class RaceDetailAdapter : RecyclerView.Adapter<RaceDetailAdapter.RaceDetailAdapterViewHolder>() {

    private val raceDetail = ArrayList<RaceDetailModel>()

    fun updateList(raceDetail: List<RaceDetailModel>) {
        this.raceDetail.clear()
        this.raceDetail.addAll(raceDetail)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RaceDetailAdapterViewHolder {
        //view types can be HEADER OR SESSION
        //
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

    class RaceDetailAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private fun bindHeader(item: RaceDetailModel.Header) {
            itemView.findViewById<TextView>(R.id.tvTrackDetailF1).text = item.track
            itemView.findViewById<TextView>(R.id.tvDateF1_2).text = item.date
            itemView.findViewById<ImageView>(R.id.flagDetailF1)?.setImageResource(item.flag)
        }
        private fun bindSession(item: RaceDetailModel.Session) {
            itemView.findViewById<TextView>(R.id.tvSessionDate).text = item.sessionDate
            itemView.findViewById<TextView>(R.id.tvSessionName).text = item.sessionName
            itemView.findViewById<TextView>(R.id.tvSessionTime).text = item.sessionTime
        }
            fun bind(raceDetailModel: RaceDetailModel) {
                when (raceDetailModel) {
                    is RaceDetailModel.Header -> bindHeader(raceDetailModel)
                    is RaceDetailModel.Session -> bindSession(raceDetailModel)
                }
            }
        }
    }